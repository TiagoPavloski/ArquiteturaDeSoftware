package br.edu.norvana.Dao;

import br.edu.norvana.entity.Empresa;
import br.edu.norvana.entity.Local;
import br.edu.norvana.entity.Movimentacao;
import br.edu.norvana.entity.Produto;
import br.edu.norvana.entity.Usuario;

public class FactoryDao {
	
	public static InterfaceDao<Local> createLocalDao() {
		return new LocalDao();
	}
	
	public static InterfaceDao<Usuario> createUsuarioDao() {
		return new UsuarioDao();
	}

	public static InterfaceDao<Movimentacao> createMovimentacaoDao() {
		return new MovimentacaoDao();
	}
	
	public static InterfaceDao<Empresa> createEmpresaDao() {
		return new EmpresaDao();
	}
	
	public static InterfaceDao<Produto> createProdutoDao() {
		return new ProdutoDao();
	}


}
