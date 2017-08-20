package br.edu.norvana.Facade;

import java.util.List;

import br.edu.norvana.Dao.EmpresaDao;
import br.edu.norvana.Dao.ProdutoDao;
import br.edu.norvana.business.BusinessEmpresa;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.business.BusinessProduto;
import br.edu.norvana.entity.Empresa;
import br.edu.norvana.entity.Produto;

public class Facade {
	
	public void salvar(Produto p) throws BusinessException{
		
		BusinessProduto produtoBusiness = new BusinessProduto();
		
		produtoBusiness.salvar(p);
	}
	
	public void salvar(Empresa e) throws BusinessException{
		
		BusinessEmpresa empresaBusiness = new BusinessEmpresa();
		
		empresaBusiness.salvar(e);
	}
	
	public List<Produto> listarProduto(){
		
		return new ProdutoDao().listar();	
	}
	
	public List<Empresa> listarEmpresa(){
		
		return new EmpresaDao().listar();	
	}
	
	
}


