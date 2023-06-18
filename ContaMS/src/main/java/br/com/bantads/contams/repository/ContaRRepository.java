package br.com.bantads.contams.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bantads.contams.model.ContaR;

public interface ContaRRepository extends JpaRepository<ContaR, UUID> {
	
    public ContaR findByClienteId(Integer id);
    public ContaR findByGerenteId(Integer id);
	
}
