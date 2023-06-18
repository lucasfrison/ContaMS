package br.com.bantads.contams.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bantads.contams.dto.ContaCudDTO;

@CrossOrigin
@RestController
public class ContaRREST {

    /*@Autowired
    private ContaRRepository contaRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;*/
	
    @GetMapping("/conta/{id}")
    public ResponseEntity<ContaCudDTO> buscarConta(@PathVariable("id") int id) {
    	throw new UnsupportedOperationException();
    }
    
    @GetMapping("/conta")
    public ResponseEntity<List<ContaCudDTO>> buscarTodasAsContas(@PathVariable("id") int id) {
    	throw new UnsupportedOperationException();
    }

}
