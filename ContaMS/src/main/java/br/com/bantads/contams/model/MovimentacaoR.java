package br.com.bantads.contams.model;

import java.io.Serializable;
import java.util.Date;

import br.com.bantads.contams.dto.ContaRDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
@Entity
@Table(name = "tb_movimentacoesr")
public class MovimentacaoR implements Serializable, Comparable<MovimentacaoR> {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_mov")
	private Integer id;
	@Column(name="data_mov")
	private Date data;
	@Column(name="tipo_mov")
	private TipoMovimentacao tipo;
	@Column(name="valor_mov")
	private Double valor;
	@Column(name="id_origem")
	private ContaR origem;
	@Column(name="id_destino")
	private ContaR destino;

	@Override
	public int compareTo(MovimentacaoR o) {
		// TODO Auto-generated method stub
		return 0;
	}

}*/
