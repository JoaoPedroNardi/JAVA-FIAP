
package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import java.math.BigDecimal;
import java.util.List;

import dominio.Mercado;

public class AtualizandoMercado {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cp2");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin(); // h� a necessidade de se fazer uma transa��o ao inserir algo no bd

		Mercado mercado = em.find(Mercado.class, 1L);
		
		System.out.println("Nome do produto atual: " + mercado.getNomeProduto());
		mercado.setPrateleira(mercado.getPrateleira());
		System.out.println("Nova prateleira: " + mercado.getPrateleira());

		em.getTransaction().commit();

		System.out.println("pronto!");
		em.close(); // fechando...
		emf.close();

	}

}
