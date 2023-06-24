package br.com.bantads.contams.repository.read;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bantads.contams.model.ContaCud;
import br.com.bantads.contams.model.ContaR;
public interface ContaRRepository extends JpaRepository<ContaR, Integer> {
	
	public ContaR findByNumero(String numero);
	public ContaR findById(int id);
	public void save(ContaCud conta);
	
}
