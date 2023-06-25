package br.com.bantads.contams.dto;

import java.util.Date;

import br.com.bantads.contams.model.TipoMovimentacao;

public class MovimentacaoRDTO {

	private Integer id;
	private Date data;
	private TipoMovimentacao tipo;
	private Double valor;
	private Integer origemId;
	private Integer destinoId;
	
	
	
	public MovimentacaoRDTO() {
		super();
	}
	
	public MovimentacaoRDTO(Date data, TipoMovimentacao tipo, Double valor, Integer origem, Integer destino) {
		super();
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.origemId = origem;
		this.destinoId = destino;
	}
	public MovimentacaoRDTO(Integer id, Date data, TipoMovimentacao tipo, Double valor, Integer origem,
			Integer destino) {
		super();
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.origemId = origem;
		this.destinoId = destino;
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
	public Integer getOrigem() {
		return origemId;
	}
	public void setOrigem(Integer origem) {
		this.origemId = origem;
	}
	public Integer getDestino() {
		return destinoId;
	}
	public void setDestino(Integer destino) {
		this.destinoId = destino;
	}
	
	
	
}
