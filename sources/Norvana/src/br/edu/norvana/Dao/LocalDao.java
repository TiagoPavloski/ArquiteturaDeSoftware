package br.edu.norvana.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.norvana.entity.Local;



public class LocalDao implements InterfaceDao<Local> {
	
	public void salvar(Local l) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
	em.getTransaction().begin();
		
		if (l.getId() != null) 
			em.merge(l);
		else
			em.persist(l);
		
		
		em.getTransaction().commit();
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<Local> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Local");		
		List<Local> locais = q.getResultList();
		em.getTransaction().commit();		
		em.close();
		
		return locais;
	}	
	
	public void excluir(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		Local local = (Local) em.find(Local.class,id);
		em.getTransaction().begin();
		em.remove(local); 
		em.getTransaction().commit();
		em.close();			
	}

}
