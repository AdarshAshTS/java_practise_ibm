const request = require("supertest");
const mongoose = require("mongoose");

const app = require("../../index");
const connectDB = require("../db/mongoose");
const User = require("../models/user");

beforeAll(async () => {
  await connectDB();
});

beforeEach(async () => {
  await User.deleteMany({});
});

afterAll(async () => {
  await User.deleteMany({});

  await mongoose.connection.close();
});

test("Should signup a new user", async () => {
  const response = await request(app)
    .post("/users")
    .send({
      name: "Test User",
      email: "test@example.com",
      password: "MyPass777",
    })
    .expect(201);

  const user = await User.findById(response.body.user._id);

  expect(user).not.toBeNull();
  expect(response.body.token).toBeDefined();
});

test("Should not signup with invalid data", async () => {
  await request(app)
    .post("/users")
    .send({
      name: "Test User",
    })
    .expect(400);
});

test("Should login existing user", async () => {
  await request(app).post("/users").send({
    name: "Test User",
    email: "test@example.com",
    password: "MyPass777",
  });

  const response = await request(app)
    .post("/users/login")
    .send({
      email: "test@example.com",
      password: "MyPass777",
    })
    .expect(200);

  expect(response.body.token).toBeDefined();
  expect(response.body.user).toBeDefined();
});

test("Should not login non-existing user", async () => {
  await request(app)
    .post("/users/login")
    .send({
      email: "wrong@example.com",
      password: "wrongpassword",
    })
    .expect(400);
});