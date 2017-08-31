package com.planner.desafio.util.jpa;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe utilitária para a interceptação e binding de transações de persistência. O método para
 * ser interceptado pelo CDI, deve ser anotado por (Transactional).     
 * 
 * @author Gilmar Carlos
 *
 */
@Interceptor
@Transactional
public class InterceptorTransactional implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entity;

	/**
	 * Responsável por fazer o binding de uma transação. 
	 *  
	 * @param context objeto do contexto que contém a transação a ser processada
	 * @return object retorna o objeto resultante do processo transacional
	 * 
	 * @throws Exception lança uma exception se houver erros no processo
	 */
	@AroundInvoke
	public Object contextInterceptor(InvocationContext context) throws Exception {
		EntityTransaction entityTransaction = entity.getTransaction();
		
		entityTransaction.begin();
		Object object = context.proceed();
		entityTransaction.commit();
		
		return object;

	}

}
