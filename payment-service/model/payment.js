const Mongoose = require("mongoose")
const paymentSchema = new Mongoose.Schema({
  courseId: {
    type: String,
    required: true,
  },
  status: {
    type: String,
  },
  amount: {
    type: String,
  },
  mode: {
    type: String,
  },
})
var Payment = Mongoose.model("Payment", paymentSchema);
module.exports = Payment;