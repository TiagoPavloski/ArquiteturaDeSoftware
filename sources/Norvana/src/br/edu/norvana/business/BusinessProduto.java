package br.edu.norvana.business;

import br.edu.norvana.Dao.InterfaceDao;
import br.edu.norvana.Dao.ProdutoDao;
import br.edu.norvana.entity.Produto;

public class BusinessProduto {
	
	public void salvar (Produto p) throws BusinessException{
		
		if (p.getCodigo() == null || p.getCodigo().equals("")){
			
			throw new BusinessException("C�digo do produto inv�lido");
		}
		
		InterfaceDao<Produto> produtoDao = new ProdutoDao();
		produtoDao.salvar(p);
	}

}
