package com.github.pomona.port.adapter.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	public EntityManagerProducer () {
		factory = Persistence.createEntityManagerFactory("PomonaPU");
	}
	
	@Produces
	//@ApplicationScoped
	//@Singleton
	//@Dependent
	@RequestScoped
	public EntityManager createEntityManager () {
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
}
