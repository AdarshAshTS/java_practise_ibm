const request = require("supertest");
const mongoose = require("mongoose");

const app = require("../../index");
const connectDB = require("../db/mongoose");
const User = require("../models/user");
const Task = require("../models/task");

let userOne;
let userOneToken;

beforeAll(async () => {
  await connectDB();
});

beforeEach(async () => {
  await User.deleteMany({});
  await Task.deleteMany({});

  userOne = new User({
    name: "Test User",
    email: "test@example.com",
    password: "MyPass777",
  });

  await userOne.save();

  userOneToken = await userOne.generateAuthToken();
});

afterAll(async () => {
  await User.deleteMany({});
  await Task.deleteMany({});

  await mongoose.connection.close();
});

test("Should create task for user", async () => {
  const response = await request(app)
    .post("/tasks")
    .set("Authorization", `Bearer ${userOneToken}`)
    .send({
      description: "Test task",
    })
    .expect(201);

  const task = await Task.findById(response.body._id);

  expect(task).not.toBeNull();
  expect(task.description).toBe("Test task");
  expect(task.owner.toString()).toBe(userOne._id.toString());
});

test("Should not create task without auth", async () => {
  await request(app)
    .post("/tasks")
    .send({
      description: "Unauthorized task",
    })
    .expect(401);
});

test("Should fetch user tasks", async () => {
  await new Task({
    description: "Task One",
    owner: userOne._id,
  }).save();

  const response = await request(app)
    .get("/tasks")
    .set("Authorization", `Bearer ${userOneToken}`)
    .expect(200);

  expect(response.body.length).toBeGreaterThan(0);
  expect(response.body[0].description).toBe("Task One");
});

test("Should filter completed tasks", async () => {
  await Task.create({
    description: "Completed Task",
    completed: true,
    owner: userOne._id,
  });

  await Task.create({
    description: "Pending Task",
    completed: false,
    owner: userOne._id,
  });

  const response = await request(app)
    .get("/tasks?completed=true")
    .set("Authorization", `Bearer ${userOneToken}`)
    .expect(200);

  expect(response.body.length).toBe(1);

  response.body.forEach((task) => {
    expect(task.completed).toBe(true);
  });
});