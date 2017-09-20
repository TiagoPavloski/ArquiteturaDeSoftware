package br.edu.norvana.Facade;

import java.util.List;

import br.edu.norvana.Dao.EmpresaDao;
import br.edu.norvana.Dao.LocalDao;
import br.edu.norvana.Dao.MovimentacaoDao;
import br.edu.norvana.Dao.ProdutoDao;
import br.edu.norvana.Dao.UsuarioDao;
import br.edu.norvana.business.BusinessEmpresa;
import br.edu.norvana.business.BusinessException;
import br.edu.norvana.business.BusinessLocal;
import br.edu.norvana.business.BusinessMovimentacao;
import br.edu.norvana.business.BusinessProduto;
import br.edu.norvana.business.BusinessUsuario;
import br.edu.norvana.entity.Empresa;
import br.edu.norvana.entity.Local;
import br.edu.norvana.entity.Movimentacao;
import br.edu.norvana.entity.Produto;
import br.edu.norvana.entity.Usuario;

public class Facade {
	
	public void salvar(Produto p) throws BusinessException{
		
		BusinessProduto produtoBusiness = new BusinessProduto();
		
		produtoBusiness.salvar(p);
	}
	
	public void salvar(Empresa e) throws BusinessException{
		
		BusinessEmpresa empresaBusiness = new BusinessEmpresa();
		
		empresaBusiness.salvar(e);
	}
	
	public void salvar(Usuario u) throws BusinessException{
		
		BusinessUsuario usuarioBusiness = new BusinessUsuario();
		
		usuarioBusiness.salvar(u);
	}
	
	public void salvar(Local l) throws BusinessException{
		
		BusinessLocal localBusiness = new BusinessLocal();
		
		localBusiness.salvar(l);
	}
	
	public void salvar(Movimentacao m) throws BusinessException{
		
		BusinessMovimentacao movimentacaoBusiness = new BusinessMovimentacao();
		
		movimentacaoBusiness.salvar(m);
	}
	
	public List<Produto> listarProduto(){
		
		return new ProdutoDao().listar();	
	}
	
	public List<Empresa> listarEmpresa(){
		
		return new EmpresaDao().listar();	
	}
	
	public List<Usuario> listarUsuario(){
		
		return new UsuarioDao().listar();	
	}

	public List<Local> listarLocal(){
		
		return new LocalDao().listar();	
	}
	
	public List<Movimentacao> listarMovimentacao(){
		
		return new MovimentacaoDao().listar();	
	}
	
	public void excluir(Long id) throws BusinessException{
		
		new ProdutoDao().excluir(id);	
		
		//BusinessProduto produtoBusiness = new BusinessProduto();
		
		//produtoBusiness.excluir(p);
	}
	
}


