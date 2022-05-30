package aplicacao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import dominio.Proprietario;
import dominio.Mercado;
import dominio.Produto;
import dominio.Proprietario;
import dominio.TipoSetor;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cp2");
		EntityManager em = emf.createEntityManager();

		
		em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao inserir algo no bd		
		
		
		//CLOB
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Produto em otimo estado");
		
		//cheves compostas usando date para pegar a data atual e o CLOB para usar as especificacoes e ENUM
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.setTelefone("(34) 1234-5678");
		Mercado mercado = new Mercado();	
		mercado.setNomeProduto("Alface");
		mercado.setPrateleira("47B");
		mercado.setDataCadastro(LocalDate.now());
		mercado.setTipoSetor(TipoSetor.ALIMENTOS);
		mercado.setEspecificacoes(especificacoes.toString());
		mercado.setProprietario(proprietario);
		em.persist(mercado);

			
		em.getTransaction().commit();
						

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
