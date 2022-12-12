package br.com.treinamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.treinamento.model.Remessa;

@Repository
public class RemessaDAO {

	private EntityManager em;

	@Autowired
	public RemessaDAO(EntityManager em) {
		this.em = em;
	}

	public Long adicionarRemessa(Remessa remessa) {
		em.persist(remessa);
		em.flush();
		return remessa.getId();
	}

	public Remessa getRemessa(int id) {
		return getRemessas().get(id);
	}

	public void removerRemessa(int id) {
		em.remove(getRemessa(id));
	}

	public void atualizarRemessa(Remessa remessa) {
		em.merge(remessa);
	}

	public List<Remessa> getRemessas() {
		return em.createQuery("SELECT remessa FROM Remessa remessa", Remessa.class).getResultList();
	}

}
