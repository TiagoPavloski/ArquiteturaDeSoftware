package br.edu.norvana.business;

import br.edu.norvana.Dao.EmpresaDao;
import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.entity.Empresa;

public class BusinessEmpresa {
	
	public void salvar (Empresa e) throws BusinessException{
		
		if (e.getNome() == null || e.getNome().equals("")){
			
			throw new BusinessException("Nome da empresa inválido");
		}
		
		InterfaceDao<Empresa> empresaDao = new EmpresaDao();
		empresaDao.salvar(e);
	}
}
