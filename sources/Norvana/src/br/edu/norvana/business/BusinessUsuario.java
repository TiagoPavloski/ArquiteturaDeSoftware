package br.edu.norvana.business;

import br.edu.norvana.Dao.FactoryDao;
import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.entity.Usuario;

public class BusinessUsuario {
	
	public void salvar (Usuario u) throws BusinessException{
		
		if (u.getNome() == null || u.getNome().equals("")){
			
			throw new BusinessException("Usuário inválido");
		}
		
		InterfaceDao<Usuario> usuarioDao = 
				FactoryDao.createUsuarioDao();
		usuarioDao.salvar(u);
		
	}

}
