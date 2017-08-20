package br.edu.norvana.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.Dao.ProdutoDao;
import br.edu.norvana.Facade.Facade;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.business.BusinessProduto;
import br.edu.norvana.entity.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestarProduto {
	
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
		List<Produto> produtos = new Facade().listarProduto();
		
		Assert.assertEquals(true,produtos.size() > 0);
		
	}
	
	
}
