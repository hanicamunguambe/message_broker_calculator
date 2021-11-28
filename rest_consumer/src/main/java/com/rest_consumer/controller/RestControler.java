package com.rest_consumer.controller;



import com.calculator.domain.Resultado;
import com.calculator.service.RabbitMQSender;
import com.calculator_publisher.controller.CalculatorControler;
import com.rest_consumer.exception.CustomInvalidException;
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


    RabbitMQSender rabbitMQSender;

    private CalculatorControler calculatorControler;


    @GetMapping("/adicionar")
    public ResponseEntity<Resultado> addition (@RequestParam(required = false) BigDecimal a,
                                                        @RequestParam(required = false) BigDecimal b) throws CustomInvalidException {

        BigDecimal res1 = calculatorControler.addiction(a, b);

        Resultado resultado = new Resultado();
        try{

            resultado.setResultado(res1);
            rabbitMQSender.send(resultado);
        }catch (NullPointerException e){
            e.getMessage();
        }

        return new ResponseEntity <>( resultado, HttpStatus.CREATED);

    }

    @GetMapping("/subtrair")
    public ResponseEntity<Resultado> subtraction (@RequestParam(required = false) BigDecimal a,
                                             @RequestParam(required = false) BigDecimal b) throws CustomInvalidException {

        BigDecimal res1 = calculatorControler.subtraction(a, b);

        Resultado resultado = new Resultado();

        try{
            resultado.setResultado(res1);
            rabbitMQSender.send(resultado);
        }catch (NullPointerException h)
        {
            h.getMessage();
        }

        return new ResponseEntity <>( resultado, HttpStatus.CREATED);

    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Resultado> multiply (@RequestParam(required = false) BigDecimal a,
                                                 @RequestParam(required = false) BigDecimal b) {


        BigDecimal res1 = calculatorControler.multiplication(a, b);

        Resultado resultado = new Resultado();

        try{
            resultado.setResultado(res1);
            rabbitMQSender.send(resultado);
        }catch (NullPointerException h)
        {
            h.getMessage();
        }

        return new ResponseEntity <>( resultado, HttpStatus.CREATED);

    }

    @GetMapping("/dividir")
    public ResponseEntity<Resultado> division (@RequestParam(required = false) BigDecimal a,
                                                 @RequestParam(required = false) BigDecimal b) {


        BigDecimal res1 = calculatorControler.division(a, b);

        Resultado resultado = new Resultado();

        try{
            resultado.setResultado(res1);
            rabbitMQSender.send(resultado);
        }catch (NullPointerException h)
        {
            h.getMessage();
        }

        return new ResponseEntity <>( resultado, HttpStatus.CREATED);

    }

}
