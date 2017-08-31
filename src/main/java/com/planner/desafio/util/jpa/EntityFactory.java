package com.planner.desafio.util.jpa;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Serve de referência para o CDI produzir instâncias de entidades de persistência (EntityManager)
 *  
 * @author Gilmar Carlos
 *
 */
public class EntityFactory implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	
	/**
	 * Construtor padrão sem argumentos
	 * 
	 */
	public EntityFactory() {
		emf = Persistence.createEntityManagerFactory("projeto");
	}
	
	/**
	 * Factory method usado pelo CDI para criar uma instância da interface (EntityManager). 
	 *  
	 * @return entityManager retorna a instância de (EntityManager)
	 */	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * Factory method usado pelo CDI para destruir uma instância da interface (EntityManager). 
	 *  
	 * @param entity Objeto da interface (EntityManager)
	 */	
	public void destroyEntityManager(@Disposes EntityManager entity) {
		if (entity.isOpen()) {
			entity.close();
		}
	}

}
