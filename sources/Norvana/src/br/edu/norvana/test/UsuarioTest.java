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
	
	public List<Usuario> usuarios;
	Facade facade = new Facade();
	
	@Test
	public void cadastrarUsuario(){
		
		Usuario u = new Usuario();
		u.setId(null);
		u.setNome("João Silva");
		u.setEmpresa("Microsoft");
		
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
		Facade facade = new Facade();
		
		usuarios = facade.listarUsuario();
		
		Assert.assertEquals(true,usuarios.size() > 0);
		
	}
	
	@Test
	public void zeditarUsuario(){
		usuarios  = facade.listarUsuario();
		Usuario u = usuarios.get(0);
		
		u.setNome("João Silva");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(u);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,u.getNome().equals("João Silva"));
		
	}
	
	@Test
	public void zzexcluirUsuario(){
		usuarios = facade.listarUsuario();
		int i = usuarios.size();
		Usuario u = usuarios.get(0);
		
		Facade facade = new Facade();
		
		try {
			facade.excluirUsuario(u.getId());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		usuarios = facade.listarUsuario();
		
		Assert.assertEquals(true,usuarios.size() < i);
		
	}

}
