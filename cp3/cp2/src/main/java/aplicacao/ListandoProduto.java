package aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Mercado;

public class ListandoProduto {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cp2");
		EntityManager em = emf.createEntityManager();

		// em.getTransaction().begin(); // há a necessidade de se fazer uma transação ao
		// inserir algo no bd

		Query query = em.createQuery("select v from Mercado v");

		List<Mercado> mercados = query.getResultList();
		for (Mercado mercado : mercados) {
			System.out.println(mercado.getCodigo() + " - " + mercado.getPrateleira() + " " + mercado.getNomeProduto()
					+ ", Setor " + mercado.getTipoSetor() + "/" + mercado.getDataCadastro());
		}

		// em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
