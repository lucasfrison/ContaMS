package br.com.bantads.contams.rabbitmq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import aj.org.objectweb.asm.Type;
import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.dto.MovimentacaoRDTO;
import br.com.bantads.contams.model.ContaR;
import br.com.bantads.contams.model.MovimentacaoR;
import br.com.bantads.contams.repository.read.ContaRRepository;

@Component
@ComponentScan("br.com.bantads.contams.rabbitmq")
public class ContaRConsumer {
	
	@Autowired
	private ContaRRepository contaRepository;
	@Autowired
	private ModelMapper mapper;
	

    @RabbitListener(queues = "BD")
    public void receiveMessage(@Payload ContaTransfer contaTransfer) {
    	System.out.println(contaTransfer.getAction());
    	List<MovimentacaoR> movimentacoes = new ArrayList<>();
    	ContaCudDTO contaDto = contaTransfer.getContaDto(); 
    	if (contaDto.getMovimentacoes() != null)
	        for (MovimentacaoRDTO movimentacaoDTO : contaDto.getMovimentacoes()) {
	            MovimentacaoR movimentacao = mapper.map(movimentacaoDTO, MovimentacaoR.class);
	            movimentacoes.add(movimentacao);
	        }
    	ContaR novaConta = new ContaR();
    	novaConta.setId(contaDto.getId());
    	novaConta.setClienteId(contaDto.getClienteId());
    	novaConta.setGerenteId(contaDto.getGerenteId());
    	novaConta.setLimite(contaDto.getLimite());
    	novaConta.setNumero(contaDto.getNumero());
    	novaConta.setSaldo(contaDto.getSaldo());
    	novaConta.setDataCriacao(contaDto.getDataCriacao());
    	novaConta.setMovimentacoes(movimentacoes);
    	String action = contaTransfer.getAction();
    	switch (action) {
			case "inserir": {
				contaRepository.save(novaConta);
				break;
			}
			case "atualizar": {
				contaRepository.save(novaConta);
				break;
			}
			case "remover": {
				contaRepository.delete(novaConta);
				break;
			}
			case "buscar": {
				contaRepository.findById(contaTransfer.getContaR().getId());
				break;
			}
			case "buscar-todos": {
				contaRepository.findAll();
				break;
			}
		}
        
    }
		
}
