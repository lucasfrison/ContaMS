package br.com.bantads.contams.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("br.com.bantads.contams.rabbitmq")
public class ContaCudProducer {

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private ContaRConsumer aReceiver;
    
    private final String routingKey = "CONTA";

    @Autowired
    @Qualifier("CONTA")
    private org.springframework.amqp.core.Queue queue;

    public void send(ContaTransfer contaTransfer) {
        this.template.convertAndSend(routingKey, contaTransfer);
        System.out.println("Mensagem enviada: " + contaTransfer.getMessage());
    }
    
}
