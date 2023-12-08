package br.edu.ifsp.ar.postodw.repository.cliente;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.repository.fliter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> filter(ClienteFilter clienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		
		Predicate[] predicates = createConstraints(clienteFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] createConstraints(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(clienteFilter.getUser() != null) {
			predicates.add(builder.equal(
					root.get("user"), clienteFilter.getUser()));
		}
		
		if(clienteFilter.getNome() != null) {
			predicates.add(builder.equal(
					root.get("nome"), clienteFilter.getNome()));
		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
