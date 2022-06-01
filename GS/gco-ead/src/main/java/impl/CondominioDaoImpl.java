package impl;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicCommitException;

import DAO.CondominioDao;
import dominio.Condominio;
import exception.CommitException;
import exception.IdNotFindException;

public class CondominioDaoImpl implements CondominioDao {

	private EntityManager em;
	
	public CondominioDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void create(Condominio condominios) {
		em.persist(condominios);
	}

	public void update(Condominio condominios) throws IdNotFindException{
		findById(condominios.getIdCondominio());
		em.merge(condominios);
	}

	public void remove(Integer id) throws IdNotFindException{
		Condominio condominios = findById(id);
		em.remove(condominios);
	}

	public Condominio findById(Integer id) throws IdNotFindException{;
	Condominio condominios = em.find(Condominio.class,id);
		if (condominios == null){
			throw new IdNotFindException();
		}
		else {
			return condominios;
		}
	}

	public void commit() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
			}catch(Exception e) {
				em.getTransaction().rollback();
				throw new CommitException();
		}
	}


	
}