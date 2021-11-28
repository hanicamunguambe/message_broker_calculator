package com.calculator.domain;


import com.calculator.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Author Hanica Munguambe
 * @Author 14/11/2021 23:20
 */



public class Resultado  {

    @Autowired
    RabbitMQSender rabbitMQSender;

    private BigDecimal resultado;


    public Resultado() {
    }

    public Resultado(BigDecimal resultado) {
        this.resultado = resultado;
    }


    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }
}
