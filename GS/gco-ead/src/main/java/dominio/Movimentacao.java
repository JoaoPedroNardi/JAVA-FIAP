package dominio;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_MOVIMENTACAO_PORTARIA")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimentacao;
	
	@Column(name = "tp_movimentacao", nullable = false)
	private tipoMovi tipoMovimentacao;
	
	@Column(name = "dt_movimentacao", nullable = false)
	private Calendar dataMovimentacao;
	
	@ManyToOne
	@JoinColumn(name = "portaria_idPortaria")
	private Portaria portaria;
	@ManyToOne
	@JoinColumn(name = "funcionario_idFuncionario")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "visitante_idVisitante")
	private Visitante visitante;
	
	public Movimentacao() {
		
	}
	
	public Movimentacao(Long idMovimentacao, tipoMovi tipoMovimentacao, Calendar dataMovimentacao, Portaria portaria, Funcionario funcionario, Visitante visitante) {
		super();
		this.idMovimentacao = idMovimentacao;
		this.tipoMovimentacao = tipoMovimentacao;
		this.portaria = portaria;
		this.funcionario = funcionario;
		this.visitante = visitante;
	}

	public Long getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Long idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public tipoMovi getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(tipoMovi tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Calendar dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public Portaria getPortaria() {
		return portaria;
	}

	public void setPortaria(Portaria portaria) {
		this.portaria = portaria;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataMovimentacao, funcionario, idMovimentacao, portaria, tipoMovimentacao, visitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(dataMovimentacao, other.dataMovimentacao)
				&& Objects.equals(funcionario, other.funcionario)
				&& Objects.equals(idMovimentacao, other.idMovimentacao) && Objects.equals(portaria, other.portaria)
				&& tipoMovimentacao == other.tipoMovimentacao && Objects.equals(visitante, other.visitante);
	}
	
	
	
}
