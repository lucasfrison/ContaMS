package br.com.bantads.contams.dto;

import java.util.Date;

import br.com.bantads.contams.model.TipoMovimentacao;

public class MovimentacaoRDTO {

	private Integer id;
	private Date data;
	private TipoMovimentacao tipo;
	private Double valor;
	private ContaRDTO origem;
	private ContaRDTO destino;
	
	
	
	public MovimentacaoRDTO() {
		super();
	}
	
	public MovimentacaoRDTO(Date data, TipoMovimentacao tipo, Double valor, ContaRDTO origem, ContaRDTO destino) {
		super();
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.origem = origem;
		this.destino = destino;
	}
	public MovimentacaoRDTO(Integer id, Date data, TipoMovimentacao tipo, Double valor, ContaRDTO origem,
			ContaRDTO destino) {
		super();
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.origem = origem;
		this.destino = destino;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public TipoMovimentacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ContaRDTO getOrigem() {
		return origem;
	}
	public void setOrigem(ContaRDTO origem) {
		this.origem = origem;
	}
	public ContaRDTO getDestino() {
		return destino;
	}
	public void setDestino(ContaRDTO destino) {
		this.destino = destino;
	}
	
	
	
}
