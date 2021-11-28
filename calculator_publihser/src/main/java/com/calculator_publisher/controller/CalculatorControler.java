package com.calculator_publisher.controller;

import com.calculator_publisher.service.RabbitMQConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculatorControler {



    @Autowired
    RabbitMQConsumer rabbitMQConsumer;


    public static BigDecimal addiction(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

}
