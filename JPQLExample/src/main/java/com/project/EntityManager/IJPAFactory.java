package com.project.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface IJPAFactory {

	EntityManager getEntityManager();
	EntityTransaction getTransaction();
	
}
