package br.com.bantads.contams.rest;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.model.ContaCud;
import br.com.bantads.contams.repository.ContaCudRepository;

@CrossOrigin
@RestController
public class ContaCudREST {

    @Autowired
    private ContaCudRepository contaRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @PostMapping("/conta")
    public ResponseEntity<ContaCudDTO> inserirConta(@RequestBody ContaCudDTO conta) {
        if (contaRepository.findByNumero(conta.getNumero()) == null) {
            contaRepository.save(mapper.map(conta, ContaCud.class));
            ContaCud contaNova = contaRepository.findByNumero(conta.getNumero());
            return ResponseEntity.status(201).body(mapper.map(contaNova, ContaCudDTO.class));
        } else {
            return ResponseEntity.status(400).build();
        }
    }
    
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}
