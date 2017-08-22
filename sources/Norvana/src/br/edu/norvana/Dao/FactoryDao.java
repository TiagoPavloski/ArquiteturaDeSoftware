package br.edu.norvana.Dao;

import br.edu.norvana.entity.Local;

public class FactoryDao {
	
	public static InterfaceDao<Local> createLocalDao() {
		return new LocalDao();
	}

}
