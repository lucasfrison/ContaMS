package br.com.bantads.contams.rest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bantads.contams.dto.ContaCudDTO;
import br.com.bantads.contams.dto.ContaRDTO;
import br.com.bantads.contams.model.ContaR;
import br.com.bantads.contams.repository.ContaRRepository;

@CrossOrigin
@RestController
public class ContaRREST {

    @Autowired
    private ContaRRepository contaRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
	
    @GetMapping("/conta/{id}")
    public ResponseEntity<ContaRDTO> buscarConta(@PathVariable("id") int id) {
        ContaR conta = contaRepository.findById(id);
        if (conta != null) {
            return ResponseEntity.status(200).body(mapper.map(conta, ContaRDTO.class));
        }
        return ResponseEntity.status(404).build();
    }
    
    @GetMapping("/conta")
    public ResponseEntity<List<ContaRDTO>> buscarTodasAsContas(@PathVariable("id") int id) {
        List<ContaR> lista = contaRepository.findAll();
        Collections.sort(lista);
        return ResponseEntity.ok().body(lista.stream().map(g -> mapper.map(g, ContaRDTO.class)).collect(Collectors.toList()));
    }

}
