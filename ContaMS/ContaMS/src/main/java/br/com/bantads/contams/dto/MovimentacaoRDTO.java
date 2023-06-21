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
	
}
