package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
	@PersistenceContext
	private EntityManager en; 

	public User findById(Integer userId) {
		return en.find(User.class, userId); 
	}

	public List<User> findAll() {
		Query query = en.createQuery("from User"); 
		return query.getResultList(); 
	}

	@Transactional
	public User save(User user) {
		en.persist(user); 
		return user;
	}

	@Transactional
	public void delete(User user) {
		en.remove(user);
	}
}
