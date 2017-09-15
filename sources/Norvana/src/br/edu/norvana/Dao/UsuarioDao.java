package br.edu.norvana.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.norvana.entity.Produto;
import br.edu.norvana.entity.Usuario;

public class UsuarioDao implements InterfaceDao<Usuario> {
	
	public void salvar(Usuario u) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		Query q = em.createQuery("from Usuario");		
		List<Usuario> usuarios = q.getResultList();
		em.getTransaction().commit();		
		em.close();
		
		return usuarios;
	}
	
	public void excluir(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		//em.remove(u); 
		em.getTransaction().commit();
		em.close();		
	}

}
