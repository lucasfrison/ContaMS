package br.com.bantads.contams.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.bantads.contams.dto.MovimentacaoRDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contasr")
public class ContaR implements Serializable, Comparable<ContaR> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conta")
	private Integer id;
    @Column(name="id_cliente")
	private Integer clienteId;
    @Column(name="id_gerente")
	private Integer gerenteId;
    @Column(name="numero_conta")
    private String numero;
    @Column(name="saldo_conta")
    private Double saldo;
    @Column(name="limite_conta")
    private Double limite;
    @Column(name="criacao_conta")
    private Date dataCriacao;
    @OneToMany(mappedBy = "origem", cascade = CascadeType.ALL)
    private List<MovimentacaoR> movimentacoes;

	public ContaR() {
		super();
	}

	public ContaR(Integer id, Integer clienteId, Integer gerenteId, String numero, Double saldo, Double limite,
			Date dataCriacao, List<MovimentacaoR> movimentacoes) {
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



	public List<MovimentacaoR> getMovimentacoes() {
		return movimentacoes;
	}



	public void setMovimentacoes(List<MovimentacaoR> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}



	@Override
	public int compareTo(ContaR o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
