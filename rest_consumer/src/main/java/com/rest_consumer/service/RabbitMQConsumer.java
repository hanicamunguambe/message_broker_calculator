package com.rest_consumer.service;


import com.calculator.domain.Resultado;
import com.rest_consumer.exception.CustomInvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    private Resultado resultado;

    @RabbitListener(queues = "calculator.queue")
    public void recievedMessage() throws CustomInvalidException {
        try{
            logger.info("Resultado da operacao: " + resultado.getResultado());
        }catch (NullPointerException e){
                e.getMessage();
        }


    }
}