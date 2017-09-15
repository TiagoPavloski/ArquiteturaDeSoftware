package br.edu.norvana.test;

import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarProduto {
	
	public List<Produto> produtos;
	Facade facade = new Facade();
	
	@Test
	public void cadastrarProduto(){
		
		Produto p = new Produto();
		p.setId(null);
		p.setCodigo("P0001");
		p.setDescricao("Produto teste 01");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(p);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,p.getId() != null);
	}

	@Test
	public void listarProduto(){
		Facade facade = new Facade();
		
		produtos = facade.listarProduto();
		
		Assert.assertEquals(true,produtos.size() > 0);
		
	}
	
	@Test
	public void zeditarProduto(){
		produtos  = facade.listarProduto();
		Produto p = produtos.get(0);
		
		p.setCodigo("New0001");
		
		Facade facade = new Facade();
		
		try {
			facade.salvar(p);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(true,p.getCodigo().equals("New0001"));
		
	}
	
	@Test
	public void zzexcluirProduto(){
		produtos = facade.listarProduto();
		int i = produtos.size();
		Produto p = produtos.get(0);
		
		Facade facade = new Facade();
		
		try {
			facade.excluir(p.getId());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		produtos = facade.listarProduto();
		
		Assert.assertEquals(true,produtos.size() < i);
		
	}
	
}
