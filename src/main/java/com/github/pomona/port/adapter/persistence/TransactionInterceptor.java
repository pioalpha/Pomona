package com.github.pomona.port.adapter.persistence;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction trx = manager.getTransaction();
		
		boolean criador = false;
		
		try {
			if (!trx.isActive()) {
				trx.begin();
				trx.rollback();
				System.out.println("Transação anterior cancelada");
				
				trx.begin();
				System.out.println("Transação iniciada");
				criador = true;
			}
			System.out.println("Inicio proceed");
			return context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
				System.out.println("Rollback da transação");
			}
			
			throw e;
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
				System.out.println("Transação efetuada");
			}
		}
	}
}
