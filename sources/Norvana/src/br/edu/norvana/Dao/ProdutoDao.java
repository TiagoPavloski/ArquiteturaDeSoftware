package br.edu.norvana.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hamcrest.core.IsNull;

import br.edu.norvana.business.BusinessException;
import br.edu.norvana.entity.Produto;

public class ProdutoDao  implements InterfaceDao<Produto>  {

	public void salvar(Produto p) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		
		if (p.getId() != null) 
			em.merge(p);
		else
			em.persist(p);
		
		
		em.getTransaction().commit();
		em.close();
			
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Produto");
		List<Produto> produtos = q.getResultList();
		em.getTransaction().commit();
		em.close();
		
		return produtos;
	}
	
	public void excluir(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		Produto produto = (Produto) em.find(Produto.class,id);
		em.getTransaction().begin();
		em.remove(produto); 
		em.getTransaction().commit();
		em.close();		
	}

}
