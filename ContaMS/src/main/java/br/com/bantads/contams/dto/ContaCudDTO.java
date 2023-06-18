package br.com.bantads.contams.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaCudDTO {
	
	private Integer id;
	private Integer clienteId;
	private Integer gerenteId;
    private Double numero;
    private Double saldo;
    private Double limite;
    private Date dataCriacao;
    private List<MovimentacaoRDTO> movimentacoes;
    		
}
