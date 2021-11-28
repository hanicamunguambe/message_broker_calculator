package com.rest_consumer.controller;


import com.calculator.domain.Resposta;
import com.calculator.domain.Resultado;
import com.calculator.exception.CustomInvalidException;
import com.calculator_publisher.controller.CalculatorControler;
import com.rest_consumer.service.RabbitMQConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


/**
 * @Autora Hanica Munguambe
 * @Data 15.11.21 05:16
 **/

@RestController
@RequestMapping("/calculator")
public class RestControler {

    @Autowired
    RabbitMQConsumer rabbitMQConsumer;

    private Resultado resultado;
    private Resposta response;
    private CalculatorControler calculatorControler;


    @GetMapping("/adicionar")
    public ResponseEntity<Resposta> addition(@RequestParam(required = false) BigDecimal a,
                                                        @RequestParam(required = false) BigDecimal b) throws CustomInvalidException {

        BigDecimal res1 = calculatorControler.addiction(a, b);

        Resultado resultado = new Resultado();
        resultado.setResultado(res1);
        rabbitMQConsumer.recievedMessage();
                //send(resultado);
        Resposta response = new Resposta("Operador adicionar executado " +
                "e adicionado a quee com sucesso! Resultado =" + resultado.getResultado());
        return new ResponseEntity <>( response, HttpStatus.CREATED);

    }
/**
    @GetMapping("/subtrair")
    public ResponseEntity<Resposta> subtraction (@RequestParam(required = false) BigDecimal a,
                                             @RequestParam(required = false) BigDecimal b) throws CustomInvalidException {

        BigDecimal res1 = calculatorControler.subtraction(a, b);

        Resultado resultado = new Resultado();
        resultado.setResultado(res1);
        rabbitMQConsumer.recievedMessage();
                //send(resultado);
        Resposta response = new Resposta("Operador subtrair executado " +
                "e adicionado a quee com sucesso! Resultado =" + resultado.getResultado());
        return new ResponseEntity <>( response, HttpStatus.CREATED);

    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Resposta> multiply (@RequestParam(required = false) BigDecimal a,
                                                 @RequestParam(required = false) BigDecimal b) {


        BigDecimal res1 = calculatorControler.multiplication(a, b);

        Resultado resultado = new Resultado();
        resultado.setResultado(res1);
        rabbitMQConsumer.send(resultado);
        Resposta response = new Resposta("Operador multiplicar executado " +
                "e adicionado a quee com sucesso! Resultado =" + resultado.getResultado());
        return new ResponseEntity <>( response, HttpStatus.CREATED);

    }

    @GetMapping("/dividir")
    public ResponseEntity<Resposta> division (@RequestParam(required = false) BigDecimal a,
                                                 @RequestParam(required = false) BigDecimal b) {


        BigDecimal res1 = calculatorControler.division(a, b);

        Resultado resultado = new Resultado();
        resultado.setResultado(res1);
        rabbitMQConsumer.send(resultado);
        Resposta response = new Resposta("Operador dividir executado " +
                "e adicionado a quee com sucesso! Resultado =" + resultado.getResultado());
        return new ResponseEntity <>( response, HttpStatus.CREATED);

    }
**/
}
