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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@Column(name="id_origem")
	@ManyToOne
    @JoinColumn(name = "id_conta")
	private ContaR origem;
	@Column(name="id_destino")
	@ManyToOne
    @JoinColumn(name = "id_conta")
	private ContaR destino;

	@Override
	public int compareTo(MovimentacaoCud o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
