package com.calculator_publisher.controller;

import com.calculator_publisher.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorControler {


    @Autowired
    RabbitMQSender rabbitMQConsumer;

    public static BigDecimal addiction(BigDecimal a, BigDecimal b) {

        a =BigDecimal.valueOf(6);
        b =BigDecimal.valueOf(1);
        return a.add(b);
    }

    public static BigDecimal subtraction (BigDecimal a, BigDecimal b){
        return  a.subtract(b);
    }

    public static BigDecimal multiplication (BigDecimal a, BigDecimal b){
        return  a.multiply(b);
    }

    public static BigDecimal division (BigDecimal a, BigDecimal b){
        return  a.divide(b);
    }


}
