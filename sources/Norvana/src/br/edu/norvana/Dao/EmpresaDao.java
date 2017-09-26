package br.edu.norvana.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.norvana.entity.Empresa;



public class EmpresaDao implements InterfaceDao<Empresa> {

	@Override
	public void salvar(Empresa w) {
		EntityManager em = Conexao.getInstance().createEntityManager();;
		
	em.getTransaction().begin();
		
		if (w.getId() != null) 
			em.merge(w);
		else
			em.persist(w);
		
		
		em.getTransaction().commit();
		em.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();;
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Empresa");
		List<Empresa> empresas = q.getResultList();
		em.getTransaction().commit();
		
		return empresas;
	}
	
	public void excluir(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		Empresa empresa = (Empresa) em.find(Empresa.class,id);
		em.getTransaction().begin();
		em.remove(empresa); 
		em.getTransaction().commit();
		em.close();			
	}
	

}
