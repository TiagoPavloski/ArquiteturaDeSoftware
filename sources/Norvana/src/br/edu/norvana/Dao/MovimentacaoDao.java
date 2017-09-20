package br.edu.norvana.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.norvana.entity.Movimentacao;


public class MovimentacaoDao implements InterfaceDao<Movimentacao> {

	@Override
	public void salvar(Movimentacao m) {
		EntityManager em = Conexao.getInstance().createEntityManager();;
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Movimentacao> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();;
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Movimentacao");
		List<Movimentacao> movimentacoes = q.getResultList();
		em.getTransaction().commit();
		
		return movimentacoes;
	}
	
	public void excluir(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		//em.remove(m); 
		em.getTransaction().commit();
		em.close();		
	}

}
