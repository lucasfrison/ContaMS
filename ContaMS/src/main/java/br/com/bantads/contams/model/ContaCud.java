package br.com.bantads.contams.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.bantads.contams.dto.MovimentacaoRDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_contascud")
public class ContaCud implements Serializable, Comparable<ContaCud>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conta")
	private Integer id;
    @Column(name="id_cliente")
	private Integer clienteId;
    @Column(name="id_gerente")
	private Integer gerenteId;
    @Column(name="numero_conta")
    private Double numero;
    @Column(name="saldo_conta")
    private Double saldo;
    @Column(name="limite_conta")
    private Double limite;
    @Column(name="criacao_conta")
    private Date dataCriacao;
    @OneToMany(mappedBy = "origem")
    private List<MovimentacaoRDTO> movimentacoes;

	@Override
	public int compareTo(ContaCud o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
