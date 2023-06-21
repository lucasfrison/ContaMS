package br.com.bantads.contams.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ContaRConsumer {

    @RabbitListener(queues = "fila-conta")
    public void receiveMessage(String message) {
        System.out.println("Mensagem recebida: " + message);
        // Lógica para processar a mensagem recebida
    }
		
}
