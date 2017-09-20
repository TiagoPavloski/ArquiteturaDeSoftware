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
public class EmpresaTest {
	
	public List<Empresa> empresas;
	Facade facade = new Facade();
	
	@Test
	public void cadastrarEmpresa(){
		
		Empresa w = new Empresa();
		w.setId(null);
		w.setCnpj("00.000.000/0000-00");
		w.setRazaoSocial("Empresa teste 01");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(w);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,w.getId() != null);
	}

	@Test
	public void listarEmpresa(){
		Facade facade = new Facade();
		
		empresas = facade.listarEmpresa();
		
		Assert.assertEquals(true,empresas.size() > 0);
		
	}
	
	@Test
	public void zeditarEmpresa(){
		empresas  = facade.listarEmpresa();
		Empresa w = empresas.get(0);
		
		w.setCnpj("New0001");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(w);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,w.getCnpj().equals("New00.000.000/0000-00"));
		
	}
	
	@Test
	public void zzexcluirEmpresa(){
		empresas = facade.listarEmpresa();
		int i = empresas.size();
		Empresa w = empresas.get(0);
		
		Facade facade = new Facade();
		
		try {
			facade.excluir(w.getId());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		empresas = facade.listarEmpresa();
		
		Assert.assertEquals(true,empresas.size() < i);
		
	}
}
