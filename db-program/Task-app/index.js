require("dotenv").config();

const express = require("express");

const userRouter = require("./src/routes/user");
const taskRouter = require("./src/routes/task");

const app = express();

// Middleware
app.use(express.json());

// Routes
app.use(userRouter);
app.use(taskRouter);

// Only start the server when this file is run directly.
// This prevents Jest/Supertest from starting another server
// when it does: require("../../index")
if (require.main === module) {
  const connectDB = require("./src/db/mongoose");

  const startServer = async () => {
    try {
      await connectDB();

      app.listen(3000, () => {
        console.log("Server running on port 3000");
      });
    } catch (error) {
      console.error("Failed to start server:", error.message);
      process.exit(1);
    }
  };

  startServer();
}

module.exports = app;