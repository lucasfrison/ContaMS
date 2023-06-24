package br.com.bantads.contams.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.model.ContaCud;
import br.com.bantads.contams.model.ContaR;
import br.com.bantads.contams.rabbitmq.ContaCudProducer;
import br.com.bantads.contams.rabbitmq.ContaRConsumer;
import br.com.bantads.contams.rabbitmq.ContaTransfer;
import br.com.bantads.contams.rabbitmq.RabbitMQConfig;
import br.com.bantads.contams.repository.command.ContaCudRepository;
import br.com.bantads.contams.repository.read.ContaRRepository;

@CrossOrigin
@RestController
public class ContaCudREST {

    @Autowired
    private ContaCudRepository contaCudRepository;
    @Autowired
    private ContaRRepository contaRRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ContaCudProducer aSender;
    
    @PostMapping("/conta")
    public ResponseEntity<ContaRDTO> inserirConta(@RequestBody ContaCudDTO conta) {
        if (contaRRepository.findByNumero(conta.getNumero()) == null) {
            contaCudRepository.save(mapper.map(conta, ContaCud.class));
            aSender.send(new ContaTransfer(mapper.map(conta, ContaR.class), "inserir", "conta-inserida"));
            ContaR contaNova = contaRRepository.findByNumero(conta.getNumero());
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
    
    @PutMapping("/conta")
    public ResponseEntity<ContaRDTO> alterarConta(@RequestBody ContaCudDTO conta) {
        if (contaRRepository.findById(conta.getId()) != null) {
            contaCudRepository.save(mapper.map(conta, ContaCud.class));
            aSender.send(new ContaTransfer(mapper.map(conta, ContaR.class), "atualizar", "conta-atualizada"));
            ContaR contaNova = contaRRepository.findByNumero(conta.getNumero());
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/conta/{id}")
    public ResponseEntity<ContaRDTO> removerConta(@PathVariable("id") int id) {
    	ContaR conta = contaRRepository.findById(id);
        if (contaRRepository.findById(id) != null) {
            contaCudRepository.deleteById(id);
            aSender.send(new ContaTransfer(mapper.map(conta, ContaR.class), "remover", "conta-removida"));
            ContaR contaRemovida = contaRRepository.findById(id);
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
	
}
