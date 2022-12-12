package br.com.treinamento.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.treinamento.model.Remessa;
import br.com.treinamento.model.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;

	@Autowired
	public UsuarioDAO(EntityManager em) {
		this.em = em;
	}

	public Usuario buscarPorUsername(String username) {
		return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :username", Usuario.class)
				.setParameter("username", username)
				.getSingleResult();
	}
	
	
	public Usuario buscarPorEmail(String email) {
		return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
				.setParameter("email", email)
				.getSingleResult();
	}

	public void deletar(Usuario usuario) {
		em.remove(usuario);
	}
	
	public void adicionarUsuario(Usuario usuario) {
		em.persist(usuario);
	}

}
