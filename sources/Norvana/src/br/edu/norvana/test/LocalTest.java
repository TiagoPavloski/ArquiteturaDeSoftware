package br.edu.norvana.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.Facade.Facade;
import br.edu.norvana.entity.Local;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalTest {
	
	public List<Local> locais;
	Facade facade = new Facade();
	
	@Test
	public void cadastrarLocal(){
		
		Local l = new Local();
		l.setId(null);
		l.setCodigo("P0001");
		l.setDescricao("Local teste 01");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(l);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,l.getId() != null);
	}

	@Test
	public void listarLocal(){
		Facade facade = new Facade();
		
		locais = facade.listarLocal();
		
		Assert.assertEquals(true,locais.size() > 0);
		
	}
	
	@Test
	public void zeditarLocal(){
		locais  = facade.listarLocal();
		Local l = locais.get(0);
		
		l.setCodigo("New0001");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(l);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,l.getCodigo().equals("New0001"));
		
	}
	
	@Test
	public void zzexcluirLocal(){
		locais = facade.listarLocal();
		int i = locais.size();
		Local l = locais.get(0);
		
		Facade facade = new Facade();
		
		try {
			facade.excluir(l.getId());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		locais = facade.listarLocal();
		
		Assert.assertEquals(true,locais.size() < i);
		
	}
}
