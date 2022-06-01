package dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_GCO_PORTARIA")
public class Portaria{
	
	//@EmbeddedId	
	//private Condominio codigo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPortaria;

	@Column(name = "nr_portaria", nullable = false)
	private int numeroPortaria;
	
	@Column(name = "nm_portaria", nullable = false)
	private String nomePortaria;
	
	@Column(name = "st_status", nullable = false)
	private Status status;
	
	@Column(name="dt_inicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column(name="dt_termino", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataTermino;
	
	@ManyToOne
	@JoinColumn(name = "condominio_idCondominio")
	private Condominio condominio;
	
	@OneToMany(mappedBy = "portaria")
	private List<Movimentacao> movimentacoes;

	public Portaria() {
	}

	public Portaria(Long idPortaria, int numeroPortaria, String nomePortaria, Status status, Calendar dataInicio, Calendar dataTermino, Condominio condominio, List<Movimentacao> movimentacoes) {
		super();
		this.idPortaria = idPortaria;
		this.numeroPortaria = numeroPortaria;
		this.nomePortaria = nomePortaria;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.condominio = condominio;
		this.movimentacoes = movimentacoes;
	}

	public Long getIdPortaria() {
		return idPortaria;
	}

	public void setIdPortaria(Long idPortaria) {
		this.idPortaria = idPortaria;
	}

	public int getNumeroPortaria() {
		return numeroPortaria;
	}

	public void setNumeroPortaria(int numeroPortaria) {
		this.numeroPortaria = numeroPortaria;
	}

	public String getNomePortaria() {
		return nomePortaria;
	}

	public void setNomePortaria(String nomePortaria) {
		this.nomePortaria = nomePortaria;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(condominio, dataInicio, dataTermino, idPortaria, movimentacoes, nomePortaria,
				numeroPortaria, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portaria other = (Portaria) obj;
		return Objects.equals(condominio, other.condominio) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(dataTermino, other.dataTermino) && Objects.equals(idPortaria, other.idPortaria)
				&& Objects.equals(movimentacoes, other.movimentacoes)
				&& Objects.equals(nomePortaria, other.nomePortaria) && numeroPortaria == other.numeroPortaria
				&& status == other.status;
	}

	
	
	
	
	
}
