const mongoose = require("mongoose");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");

const userSchema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: true,
      trim: true,
    },

    age: {
      type: Number,
    },

    email: {
      type: String,
      required: true,
      unique: true,
      trim: true,
      lowercase: true,
    },

    password: {
      type: String,
      required: true,
      minlength: 6,
    },

    tokens: [
      {
        token: {
          type: String,
          required: true,
        },
      },
    ],
  },
  {
    timestamps: true,
  }
);

// Virtual relationship:
// User -> Tasks
userSchema.virtual("tasks", {
  ref: "Task",
  localField: "_id",
  foreignField: "owner",
});

// Hash password before saving
userSchema.pre("save", async function (next) {
  try {
    if (this.isModified("password")) {
      this.password = await bcrypt.hash(this.password, 8);
    }

   // next();
  } catch (error) {
    next(error);
  }
});

// Generate authentication token
userSchema.methods.generateAuthToken = async function () {
  const user = this;

  const token = jwt.sign(
    {
      _id: user._id.toString(),
    },
    process.env.JWT_SECRET
  );

  user.tokens.push({
    token,
  });

  await user.save();

  return token;
};

const User = mongoose.model("User", userSchema);

module.exports = User;