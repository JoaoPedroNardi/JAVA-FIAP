package impl;

import javax.persistence.EntityManager;

import DAO.GenericDao;
import exception.CommitException;
import exception.IdNotFindException;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	
	private EntityManager em;
	
	private Class<E> clazz;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<E>) ((ParameterizedType)
				getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void create(E Entity) {
		em.persist(Entity);
	}

	public void update(E Entity) throws IdNotFindException{
		em.merge(Entity);
	}

	public void remove(K id) throws IdNotFindException{
		E Entity = findById(id);
		em.remove(Entity);
	}
	
	public E findById(K id) throws IdNotFindException{;
	E Entity = em.find(clazz, id);
	if (Entity == null){
		throw new IdNotFindException();
	}
	else {
		return Entity;
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
