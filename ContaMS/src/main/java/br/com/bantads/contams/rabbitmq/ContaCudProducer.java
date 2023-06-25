package br.com.bantads.contams.rabbitmq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.dto.MovimentacaoRDTO;
import br.com.bantads.contams.model.ContaR;
import br.com.bantads.contams.model.MovimentacaoR;

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
    	List<MovimentacaoRDTO> movimentacoes = new ArrayList<>();
    	ContaRDTO contaDto = new ContaRDTO(); 
    	if (message.getMovimentacoes() != null)
	        for (MovimentacaoR mov : message.getMovimentacoes()) {
	            MovimentacaoRDTO movimentacao = new MovimentacaoRDTO(
	            	mov.getId(),
	            	mov.getData(),
	            	mov.getTipo(),
	            	mov.getValor(),
	            	mov.getOrigem().getId(),
	            	mov.getDestino().getId()
	            );
	            movimentacoes.add(movimentacao);
	        }
    	ContaRDTO novaConta = new ContaRDTO();
    	novaConta.setId(contaDto.getId());
    	novaConta.setClienteId(contaDto.getClienteId());
    	novaConta.setGerenteId(contaDto.getGerenteId());
    	novaConta.setLimite(contaDto.getLimite());
    	novaConta.setNumero(contaDto.getNumero());
    	novaConta.setSaldo(contaDto.getSaldo());
    	novaConta.setDataCriacao(contaDto.getDataCriacao());
    	novaConta.setMovimentacoes(movimentacoes);
    	this.template.convertAndSend(routingKey, objectMapper.writeValueAsString(message));
    }
    
}
