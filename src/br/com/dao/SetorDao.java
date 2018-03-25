package br.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.model.Setor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) //opcional
// @TransactionManagement(TransactionManagementType.BEAN) //opcional - trasação na mão
public class SetorDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Setor> obter() {
		return em.createQuery("select s from Setor s", Setor.class).getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED) //opcional
	public void salvar(Setor setor) {
		em.persist(setor);
	}
	
}
