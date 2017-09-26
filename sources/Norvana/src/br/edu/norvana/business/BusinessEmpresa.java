package br.edu.norvana.business;

import br.edu.norvana.Dao.EmpresaDao;
import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.entity.Empresa;

public class BusinessEmpresa {
	
	public void salvar (Empresa w) throws BusinessException{
		
		if (w.getNome() == null || w.getNome().equals("")){
			
			throw new BusinessException("Nome da empresa inválido");
		}
		
		InterfaceDao<Empresa> empresaDao = new EmpresaDao();
		empresaDao.salvar(w);
	}
}
