package dominio;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_GCO_FUNC_PORTARIA")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;
	
	@Column(name = "nm_funcionario", nullable = false)
	private String nomeFuncioniario;
	
	@Column(name = "dt_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Column(name = "nr_cpf", nullable = false)
	private String cpf;
	
	@Column(name = "nr_rg", nullable = false)
	private String rg;
	
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@OneToMany
	private List<Movimentacao> movimentacoes;
	
	public Funcionario() {
		
	}
	
	public Funcionario(Long idFuncionario, Calendar dataNascimento, String cpf, String rg, LocalDate dataCadastro, String nomeFuncioniario, List<Movimentacao> movimentacoes) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeFuncioniario = nomeFuncioniario;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.dataCadastro = dataCadastro;
		this.movimentacoes = movimentacoes;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncioniario() {
		return nomeFuncioniario;
	}

	public void setNomeFuncioniario(String nomeFuncioniario) {
		this.nomeFuncioniario = nomeFuncioniario;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataCadastro, dataNascimento, idFuncionario, movimentacoes, nomeFuncioniario, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(idFuncionario, other.idFuncionario)
				&& Objects.equals(movimentacoes, other.movimentacoes)
				&& Objects.equals(nomeFuncioniario, other.nomeFuncioniario) && Objects.equals(rg, other.rg);
	}
	
	

	
	
	
	
}
