var express = require('express');
var router = express.Router();
var PaymentModel = require('../model/payment');



function createPayment(){
    // create a new user called chris

    for(let i=0;i<4;i++) {
        var payment = new PaymentModel({
            status: 'paid',
            amount: '200',
            mode: 'online',
            courseId:i
          });
          payment.save(function(err) {
            if (err) throw err;
          
            console.log('payment saved successfully!');
          });
    }
}

//createPayment();


/* GET users listing. */
router.get('/', function(req, res, next) {
    PaymentModel.find({}, function(err, payments) {
        if (err) throw err;
      
        // object of all the users
        console.log(payments);
        res.json(payments);
      });
  
});

//Todo ----Need to make payment gateway interation 
router.post("/makePayment",function(req,res){

});

module.exports = router;
