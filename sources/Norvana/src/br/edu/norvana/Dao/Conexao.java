package br.edu.norvana.Dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("norvana");
	
	public static EntityManagerFactory getInstance(){
		return emf;
	}
}
