package br.edu.norvana.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioTest {
	
	@Test
	public void cadastrarUsuario(){
		
		Usuario u = new Usuario();
		u.setId(null);
		u.setNome("Dioggines Silva");
		u.setEmpresa("E0001");
		
	Facade facade = new Facade();
		
		try {
			facade.salvar(u);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,u.getId() != null);
	}
	
	@Test
	public void listarUsuario(){
		List<Usuario> usuarios = new Facade().listarUsuario();
		
		Assert.assertEquals(true,usuarios.size() > 0);
		
	}

}
