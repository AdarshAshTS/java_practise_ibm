const express = require("express");
const bcrypt = require("bcryptjs");

const User = require("../models/user");

const router = new express.Router();

// Signup
router.post("/users", async (req, res) => {
  try {
    const user = new User(req.body);

    await user.save();

    const token = await user.generateAuthToken();

    res.status(201).send({
      user,
      token,
    });
  } catch (error) {
    res.status(400).send({
      error: error.message,
    });
  }
});

// Login
router.post("/users/login", async (req, res) => {
  try {
    const { email, password } = req.body;

    if (!email || !password) {
      return res.status(400).send({
        error: "Email and password are required",
      });
    }

    const user = await User.findOne({
      email: email.toLowerCase(),
    });

    if (!user) {
      return res.status(400).send({
        error: "Unable to login",
      });
    }

    const isMatch = await bcrypt.compare(password, user.password);

    if (!isMatch) {
      return res.status(400).send({
        error: "Unable to login",
      });
    }

    const token = await user.generateAuthToken();

    res.send({
      user,
      token,
    });
  } catch (error) {
    res.status(400).send({
      error: error.message,
    });
  }
});

module.exports = router;