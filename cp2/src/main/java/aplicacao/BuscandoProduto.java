package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Mercado;

public class BuscandoProduto {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cp2");
		EntityManager em = emf.createEntityManager();

		//em.getTransaction().begin(); // h� a necessidade de se fazer uma transa��o ao inserir algo no bd

		Mercado mercado = em.find(Mercado.class, 2L);
		System.out.println("Produto de c�digo " + mercado.getCodigo()
		+ " � um " + mercado.getNomeProduto());

		//em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();
		

	}

}
