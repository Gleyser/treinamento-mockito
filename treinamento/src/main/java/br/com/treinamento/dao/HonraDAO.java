package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.treinamento.model.Honra;

@Repository
public class HonraDAO {
	
	private EntityManager em;

	@Autowired
	public HonraDAO(EntityManager em) {
		this.em = em;
	}
	
	public void adicionarHonra(Honra honra) {
		em.persist(honra);
	}

	public Honra getHonra(int id) {
		return getHonras().get(id);
	}

	public void removerHonra(int id) {
		em.remove(getHonra(id));
	}

	public void atualizarHonra(Honra honra) {
		em.merge(honra);
	}

	public List<Honra> getHonras() {
		return em.createQuery("SELECT honra FROM Honra honra", Honra.class).getResultList();
	}

}
