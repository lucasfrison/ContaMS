package br.com.bantads.contams.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.model.ContaR;

@Component
@ComponentScan("br.com.bantads.contams.rabbitmq")
public class ContaCudProducer {

    @Autowired
    private RabbitTemplate template;
	@Autowired
	private ObjectMapper objectMapper;
    
    private final String routingKey = "CONTA";
    private final String routingKeyBD = "BD";

    @Autowired
    @Qualifier("CONTA")
    private org.springframework.amqp.core.Queue queue;

    public void send(ContaTransfer contaTransfer) {
        this.template.convertAndSend(routingKeyBD, contaTransfer);
        System.out.println("Mensagem enviada: " + contaTransfer.getMessage());
    }
    
    public void sendString(ContaR message) throws JsonProcessingException, AmqpException {
    	this.template.convertAndSend(routingKey, objectMapper.writeValueAsString(message));
    }
    
}
