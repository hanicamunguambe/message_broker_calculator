package com.calculator.domain;

import com.calculator.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Hanica Munguambe
 * @Author 13/11/2021 17:23
 */
public class Resposta {

    @Autowired
    RabbitMQSender rabbitMQConsumer;

    private String messagem;

    public Resposta() {
    }

    public Resposta(String messagem) {
        this.messagem = messagem;
    }

    public String getMessage() {
        return messagem;
    }

    public void setMessage(String message) {
        this.messagem = messagem;
    }
}
