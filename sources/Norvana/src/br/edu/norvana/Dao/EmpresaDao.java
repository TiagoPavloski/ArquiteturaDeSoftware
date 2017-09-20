package br.edu.norvana.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.norvana.entity.Empresa;


public class EmpresaDao implements InterfaceDao<Empresa> {

	@Override
	public void salvar(Empresa e) {
		EntityManager em = Conexao.getInstance().createEntityManager();;
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
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
		
		em.getTransaction().begin();
		//em.remove(e); 
		em.getTransaction().commit();
		em.close();		
	}
	

}
