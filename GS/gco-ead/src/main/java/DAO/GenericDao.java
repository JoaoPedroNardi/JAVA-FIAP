package DAO;

import exception.CommitException;
import exception.IdNotFindException;

public interface GenericDao<E,K> {

	void create(E entity);
	
	void update(E entity) throws IdNotFindException;
	
	void remove(K id) throws IdNotFindException;
	
	E findById(K id) throws IdNotFindException;
	
	void commit() throws CommitException;
	
}

