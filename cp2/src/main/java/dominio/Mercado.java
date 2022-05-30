package dominio;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tab_mercado")
public class Mercado {
	
	@EmbeddedId	
	private Produto codigo;
	
	///@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long codigo;
	
	@Column(name = "nome_produto", nullable = false)
	private String nomeProduto;
	
	@Column(length = 60, nullable = false)
	private String prateleira;
	
	@Column(name = "tipo_setor", nullable = false)
	@Enumerated(EnumType.STRING) // EnumType.ORDINAL (insere número ao invés da string)
	private TipoSetor TipoSetor;
	
	//@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private LocalDate dataCadastro;
	
	@Lob
	private String especificacoes;
	
	@Transient
	private String descricaoCompleta;
	
	public Mercado() {
	}
	
	public Mercado(Produto codigo, String nomeProduto, TipoSetor TipoSetor, String prateleira, LocalDate dataCadastro, String especificacoes, String descricaoCompleta) {
		super();
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.prateleira = prateleira;
		this.dataCadastro = dataCadastro;
		this.especificacoes = especificacoes;
		this.TipoSetor = TipoSetor;
		this.descricaoCompleta = descricaoCompleta;
	}

	public Produto getCodigo() {
		return codigo;
	}

	public void setCodigo(Produto codigo) {
		this.codigo = codigo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}
	
	

	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}

	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}
	
	

	public TipoSetor getTipoSetor() {
		return TipoSetor;
	}

	public void setTipoSetor(TipoSetor tipoSetor) {
		TipoSetor = tipoSetor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TipoSetor, codigo, dataCadastro, descricaoCompleta, especificacoes, nomeProduto,
				prateleira);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mercado other = (Mercado) obj;
		return TipoSetor == other.TipoSetor && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(descricaoCompleta, other.descricaoCompleta)
				&& Objects.equals(especificacoes, other.especificacoes)
				&& Objects.equals(nomeProduto, other.nomeProduto) && Objects.equals(prateleira, other.prateleira);
	}

	
	
}
