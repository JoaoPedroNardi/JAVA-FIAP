package dominio;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_GCO_CONDOMINIO")
public class Condominio {

	// @EmbeddedId
	// private Portaria codigo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCondominio;

	@Column(name = "nr_cnpj", nullable = false)
	private String cnpj;

	@Column(name = "ds_razao_social", nullable = false)
	private String razaoSocial;

	@Column(name = "nm_fantasia", nullable = false)
	private String fantasia;

	@Column(name = "dt_fundacao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataFundacao;

	public Condominio() {

	}

	public Condominio(Integer idCondominio, String cnpj, String razaoSocial, String fantasia, Calendar dataFundacao) {
		super();
		this.idCondominio = idCondominio;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.dataFundacao = dataFundacao;
		//this.portarias = portarias;
	}

	public Integer getIdCondominio() {
		return idCondominio;
	}

	public void setIdCondominio(Integer idCondominio) {
		this.idCondominio = idCondominio;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, dataFundacao, fantasia, idCondominio, razaoSocial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condominio other = (Condominio) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(dataFundacao, other.dataFundacao)
				&& Objects.equals(fantasia, other.fantasia) && Objects.equals(idCondominio, other.idCondominio)
				&& Objects.equals(razaoSocial, other.razaoSocial);
	}

	//public List<Portaria> getPortarias() {
		//return portarias;
	//}

	//public void setPortarias(List<Portaria> portarias) {
		//this.portarias = portarias;
	//}

	

}
