package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class JoinRepository {
	@PersistenceContext
	private EntityManager em; 
	
	public List<Join_event> findAll() {
		Query query = em.createQuery("from Join_event"); 
		return query.getResultList(); 
	}
	
	public Join_event getJoin_event(Integer id) {
		return em.find(Join_event.class, id);
	}
}
