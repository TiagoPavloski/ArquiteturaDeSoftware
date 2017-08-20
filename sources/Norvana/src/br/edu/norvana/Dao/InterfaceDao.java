package br.edu.norvana.Dao;

import java.util.List;

public interface InterfaceDao<T> {
	
	public void salvar(T t);	
	
	public List<T> listar();	
}
