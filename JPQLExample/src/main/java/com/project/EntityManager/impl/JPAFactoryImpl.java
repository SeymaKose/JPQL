package com.project.EntityManager.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.project.EntityManager.IJPAFactory;

public class JPAFactoryImpl implements IJPAFactory{

	private EntityManager entityManager = null;
	
	public EntityManager getEntityManager() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		this.entityManager = factory.createEntityManager();
		
		return entityManager;
	}

	public EntityTransaction getTransaction() {
		
		EntityTransaction transaction = this.entityManager.getTransaction();
		
		return transaction;
	}

}
