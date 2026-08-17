const express = require("express");

const Task = require("../models/task");
const auth = require("../middleware/auth");

const router = new express.Router();

// Create task
router.post("/tasks", auth, async (req, res) => {
  try {
    const task = new Task({
      ...req.body,
      owner: req.user._id,
    });

    await task.save();

    res.status(201).send(task);
  } catch (error) {
    res.status(400).send({
      error: error.message,
    });
  }
});

// Get user's tasks
router.get("/tasks", auth, async (req, res) => {
  try {
    const match = {};
    const sort = {};

    // Filter by completed status
    if (req.query.completed !== undefined) {
      match.completed = req.query.completed === "true";
    }

    // Sort
    if (req.query.sortBy) {
      const parts = req.query.sortBy.split(":");

      const field = parts[0];
      const direction = parts[1];

      if (field && ["asc", "desc"].includes(direction)) {
        sort[field] = direction === "desc" ? -1 : 1;
      }
    }

    // Pagination
    let limit = 0;
    let skip = 0;

    if (req.query.limit) {
      limit = parseInt(req.query.limit, 10);

      if (Number.isNaN(limit) || limit < 0) {
        return res.status(400).send({
          error: "Invalid limit",
        });
      }
    }

    if (req.query.skip) {
      skip = parseInt(req.query.skip, 10);

      if (Number.isNaN(skip) || skip < 0) {
        return res.status(400).send({
          error: "Invalid skip",
        });
      }
    }

    await req.user.populate({
      path: "tasks",
      match,
      options: {
        limit,
        skip,
        sort,
      },
    });

    res.send(req.user.tasks);
  } catch (error) {
    res.status(500).send({
      error: error.message,
    });
  }
});

module.exports = router;