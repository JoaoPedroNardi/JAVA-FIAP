package aplicacao;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import impl.CondominioDaoImpl;
import dominio.Condominio;

public class Programa {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gco-ead"); 
		
		EntityManager em = emf.createEntityManager();
		
		Condominio condominios = new Condominio(null, "12312321", "teste", "Edificio FIAP", Calendar.getInstance());
		
		CondominioDaoImpl dao = new CondominioDaoImpl(em);
		
		try {
			dao.create(condominios);
			dao.commit();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		System.out.println("Condominio criado coms sucesso.");
		
		try {
			dao.findById(1);
			System.out.println(condominios.getIdCondominio());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		try {
			condominios.setFantasia("Edificio FIAP Paulista");
			dao.update(condominios);
			dao.commit();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		System.out.println("Atualizado com sucesso!");
		
		try {
			dao.remove(1);
			dao.commit();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		em.close();
		emf.close();
	}
}

