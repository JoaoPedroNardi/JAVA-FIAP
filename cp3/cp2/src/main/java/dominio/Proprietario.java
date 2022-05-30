package dominio;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
@Table(name = "proprietario")
public class Proprietario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	@Column(length = 60, nullable = false)
	private String nome;
	@Column(length = 20, nullable = false)
	private String telefone;
	@Column(length = 255)
	private String email;
	
	@OneToOne(mappedBy = "proprietario")
	private Mercado mercado;
	
	@OneToMany(mappedBy = "proprietario")
	private List<Mercado> mercados;
	
	public Proprietario() {
	}

	public Proprietario(Long codigo, String nome, String telefone, String email, List<Mercado> mercados) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.mercados = mercados;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Mercado> getVeiculos() {
		return mercados;
	}

	public void setVeiculos(List<Mercado> veiculos) {
		this.mercados = mercados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, email, nome, telefone, mercados);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proprietario other = (Proprietario) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(mercados, other.mercados);
	}

}
