package br.com.bantads.contams.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movimentacoescud")
public class MovimentacaoCud implements Serializable, Comparable<MovimentacaoCud> {

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
	@ManyToOne
	@JoinColumn(name = "id_origem")
	private ContaCud origem;
	@ManyToOne
	@JoinColumn(name = "id_destino")
	private ContaCud destino;

	@Override
	public int compareTo(MovimentacaoCud o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MovimentacaoCud(Integer id, Date data, TipoMovimentacao tipo, Double valor, ContaCud origem,
			ContaCud destino) {
		super();
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
		this.origem = origem;
		this.destino = destino;
	}

	public MovimentacaoCud() {
		super();
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

	public ContaCud getOrigem() {
		return origem;
	}

	public void setOrigem(ContaCud origem) {
		this.origem = origem;
	}

	public ContaCud getDestino() {
		return destino;
	}

	public void setDestino(ContaCud destino) {
		this.destino = destino;
	}
	
	

	
}
