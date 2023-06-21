package br.com.bantads.contams.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bantads.contams.model.ContaCud;

public interface ContaCudRepository extends JpaRepository<ContaCud, Integer> {
	

	
}