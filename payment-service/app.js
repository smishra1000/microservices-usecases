var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');


const eurekaHelper = require('./helper/eureka-helper');// eureka registry settings

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*"); // update to match the domain you will make the request from
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});


//Todo ----Need to make payment gateway interation 
app.post("/makePayment",function(req,res){

});

app.get("/payment",function(req,res){
  let payments = [
    {
      courseId:1,
      amount:"400",
      result:"paid",
      mode:'online',
      date: new Date(),

    },
    {
      courseId:2,
      amount:"600",
      result:"paid",
      mode:'online',
      date:new Date(),

    }, {
      courseId:3,
      amount:"300",
      result:"paid",
      mode:'online',
      date:new Date(),

    }
  ];
  res.json(payments)

  res.json("from nodejs microservice ");
})
// app.use('/', indexRouter);
// app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});



eurekaHelper.registerWithEureka('payment-service', 3000);
// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;
