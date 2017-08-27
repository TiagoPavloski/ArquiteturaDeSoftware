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
	
	@Test
	public void cadastrarLocal(){
		
		Local l = new Local();
		l.setId(null);
		l.setCodigo("L0001");
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
		List<Local> locais = new Facade().listarLocal();
		
		Assert.assertEquals(true,locais.size() > 0);
		
	}
}
