package dominio;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_VISITANTE")
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVisitante;
	
	@Column(name = "nm_visitante", nullable = false)
	private String nomeVisitante;
	
	@Column(name = "dt_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Column(name = "nr_cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nr_rg", nullable = false)
	private String rg;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@OneToMany(mappedBy = "visitante")
	private List<Movimentacao> movimentacoes;
	
	public Visitante() {
		
	}
	
	public Visitante(Long idVisitante, Calendar dataNascimento, String cpf, String rg, LocalDate dataCadastro, String nomeVisitante, List<Movimentacao> movimentacoes) {
		super();
		this.idVisitante = idVisitante;
		this.nomeVisitante = nomeVisitante;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
		this.movimentacoes = movimentacoes;
	}

	public Long getIdVisitante() {
		return idVisitante;
	}

	public void setIdVisitante(Long idVisitante) {
		this.idVisitante = idVisitante;
	}

	public String getNomeVisitante() {
		return nomeVisitante;
	}

	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	
	
}
