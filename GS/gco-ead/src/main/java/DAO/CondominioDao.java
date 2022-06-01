package DAO;

import dominio.Condominio;
import exception.CommitException;
import exception.IdNotFindException;

public interface CondominioDao {

	void create(Condominio condominios);
	
	void update(Condominio condominios) throws IdNotFindException;
	
	void remove(Integer id) throws IdNotFindException;
	
	Condominio findById(Integer id) throws IdNotFindException;
	
	void commit() throws CommitException;
	
}