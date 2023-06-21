package br.com.bantads.contams.dto;

import java.util.Date;
import java.util.List;

public class ContaCudDTO {
	
	private Integer id;
	private Integer clienteId;
	private Integer gerenteId;
    private String numero;
    private Double saldo;
    private Double limite;
    private Date dataCriacao;
    private List<MovimentacaoRDTO> movimentacoes;
    
	public ContaCudDTO() {
		super();
	}

	public ContaCudDTO(Integer id, Integer clienteId, Integer gerenteId, String numero, Double saldo, Double limite,
			Date dataCriacao, List<MovimentacaoRDTO> movimentacoes) {
		super();
		this.id = id;
		this.clienteId = clienteId;
		this.gerenteId = gerenteId;
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
		this.dataCriacao = dataCriacao;
		this.movimentacoes = movimentacoes;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public Integer getGerenteId() {
		return gerenteId;
	}
	public void setGerenteId(Integer gerenteId) {
		this.gerenteId = gerenteId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public List<MovimentacaoRDTO> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(List<MovimentacaoRDTO> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
    
    
    		
}
