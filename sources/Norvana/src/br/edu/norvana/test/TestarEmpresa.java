package br.edu.norvana.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarEmpresa {
	
	@Test
	public void cadastrarEmpresa(){
		
		Empresa e = new Empresa();
		e.setId(null);
		e.setNome("Empresa01");
		e.setRazaoSocial("Razao Social Empresa 01");
		e.setCnpj("78.973.744/0001-80");
		Facade facade = new Facade();
		
		try {
			facade.salvar(e);
		} catch (BusinessException ex) {
			ex.printStackTrace();
		}
		
		Assert.assertEquals(true,e.getId() != null);
	}

	@Test
	public void listarEmpresa(){
		List<Empresa> empresas = new Facade().listarEmpresa();
		
		Assert.assertEquals(true,empresas.size() > 0);
		
	}

}
