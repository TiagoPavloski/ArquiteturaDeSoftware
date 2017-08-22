package br.edu.norvana.business;

import br.edu.norvana.Dao.FactoryDao;
import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.entity.Local;

public class BusinessLocal {
	
	public void salvar (Local l) throws BusinessException{
		
		if (l.getCodigo() == null || l.getCodigo().equals("")){
			
			throw new BusinessException("Código do local inválido");
		}
		
		InterfaceDao<Local> localDao = 
				FactoryDao.createLocalDao();
		localDao.salvar(l);
		
	}
}


