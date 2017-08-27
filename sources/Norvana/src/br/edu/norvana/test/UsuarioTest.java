package br.edu.norvana.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.norvana.Dao.UsuarioDao;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.business.BusinessUsuario;
import br.edu.norvana.entity.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	
	@Test
	public void cadastrarUsuario(){
		
		Usuario u = new Usuario();
		u.setId(null);
		u.setNome("Dioggines Silva");
		u.setEmpresa("E0001");
		
		BusinessUsuario usuarioBusiness = new BusinessUsuario();
		
		try{
			usuarioBusiness.salvar(u);
		}catch (BusinessException e){
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,u.getId() != null);
		
	}
	
	@Test
	public void listarUsuario(){
		List<Usuario> usuarios = new UsuarioDao().listar();
		
		Assert.assertEquals(true,usuarios.size() > 0);
		
	}

}
