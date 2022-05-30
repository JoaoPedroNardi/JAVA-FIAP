package dominio;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dominio.Proprietario;

@Entity
@Table(name = "tab_mercado")
public class Mercado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
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
	
	
	//@Embedded
	//private ProprietarioEmbedded proprietario;
		
		///*
		// O relacionamento one-to-one aceita referências nulas, por padrão. Podemos obrigar a atribuição de proprietário durante a persistência de Veiculo, incluindo o atributo optional com valor false na anotação @OneToOne.
	@OneToOne(mappedBy = "mercado")
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;
	
	//@ManyToOne(mappedBy = "mercado")
	//@JoinColumn(name = "proprietario_codigo")
	
	public Mercado() {
	}
	
	public Mercado(Long codigo, String nomeProduto, TipoSetor TipoSetor, String prateleira, LocalDate dataCadastro, String especificacoes, String descricaoCompleta, Proprietario proprietario) {
		super();
		this.codigo = codigo;
		this.nomeProduto = nomeProduto;
		this.prateleira = prateleira;
		this.dataCadastro = dataCadastro;
		this.especificacoes = especificacoes;
		this.TipoSetor = TipoSetor;
		this.descricaoCompleta = descricaoCompleta;
		this.proprietario = proprietario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	public TipoSetor getTipoSetor() {
		return TipoSetor;
	}

	public void setTipoSetor(TipoSetor tipoSetor) {
		TipoSetor = tipoSetor;
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

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TipoSetor, codigo, dataCadastro, descricaoCompleta, especificacoes, nomeProduto, prateleira,
				proprietario);
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
				&& Objects.equals(nomeProduto, other.nomeProduto) && Objects.equals(prateleira, other.prateleira)
				&& Objects.equals(proprietario, other.proprietario);
	}
	
	

	
	
}
