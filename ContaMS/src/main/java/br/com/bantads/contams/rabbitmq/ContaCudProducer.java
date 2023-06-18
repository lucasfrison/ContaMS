package br.com.bantads.contams.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaCudProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ContaCudProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("fila-conta", message);
    }
	
}
