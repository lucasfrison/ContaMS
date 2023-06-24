package br.com.bantads.contams.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.bantads.contams.repository.read.ContaRRepository;

@Component
@ComponentScan("br.com.bantads.contams.rabbitmq")
public class ContaRConsumer {
	
	@Autowired
	private ContaRRepository contaRepository;
	

    @RabbitListener(queues = "conta")
    public void receiveMessage(@Payload ContaTransfer contaTransfer) {
    	System.out.println(contaTransfer.getAction());
        if (contaTransfer.getAction().equals("inserir")) {
        	contaRepository.save(contaTransfer.getContaCud());
        }
    }
		
}
