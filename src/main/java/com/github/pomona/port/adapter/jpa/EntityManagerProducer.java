package com.github.pomona.port.adapter.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

@ApplicationScoped
public class EntityManagerProducer {
	@PersistenceUnit
	private EntityManagerFactory pomonaFactory;
	
	//@Produces @Resource(name = "jdbc/PomonaDB")
	//@Singleton @Resource(name = "jdbc/PomonaDB")
	//@Singleton @Resource(lookup="java:comp/env/jdbc/PomonaDB")
	//@Resource(mappedName="java:/DefaultDS")
	//private DataSource ds;

	//@Produces @Resource(lookup="java:comp/env/jdbc/PomonaDB")
	//@PomonaDB DataSource pomonaDB;
	
	public EntityManagerProducer () {
		try {
			/*Properties props = new Properties();
			
			props.loadFromXML(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/persistence.xml"));
			System.out.println(props);*/
			
			System.out.println("Inicializando a Migração");
			Flyway f = new Flyway();
			//f.setDataSource(props.getProperty("javax.persistence.jdbc.url"),
			//		props.getProperty("javax.persistence.jdbc.user"),
			//		props.getProperty("javax.persistence.jdbc.password"));
			//f.setDataSource(pomonaDB);
			f.setDataSource((DataSource)InitialContext.doLookup("java:comp/env/jdbc/PomonaDB"));
			try {
				f.migrate();
		        System.out.println("Migração Finalizada");
			} catch (Exception e) {
				System.out.println(e);
			}
		//} catch (IOException e1) {
		//	e1.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}

		pomonaFactory = Persistence.createEntityManagerFactory("PomonaPU");

		/*System.out.println("Inicializando a Migração");
		Flyway f = new Flyway();
		
		//f.setDataSource("jdbc:mysql://localhost:3306/pomona", "root", "rootroot");
		//f.setDataSource(dataSource);
		
		String url = (String)factory.getProperties().get("javax.persistence.jdbc.url");
		String user = (String)factory.getProperties().get("javax.persistence.jdbc.user");
		//String password = (String)factory.getProperties().get("javax.persistence.jdbc.password");
		String password = "rootroot";
		f.setDataSource(url, user, password);
		
		//f.setDataSource((String)factory.getProperties().get("javax.persistence.jdbc.url"),
		//		(String)factory.getProperties().get("javax.persistence.jdbc.user"),
		//		(String)factory.getProperties().get("javax.persistence.jdbc.password"));
		try {
			f.migrate();
	        System.out.println("Migração Finalizada");
		} catch (Exception e) {
			System.out.println(e);
		}*/
		
        
	}
	
	/*private void migracao () {
		DataSource ds = (DataSource) createEntityManager().unwrap(javax.sql.DataSource.class);
		
		Flyway f = new Flyway();
		f.setDataSource(ds);
        f.migrate();
	}*/
	
	@Produces
	//@ApplicationScoped
	//@Singleton
	//@Dependent
	@Default
	@RequestScoped
	public EntityManager createPomonaEntityManager () {
		return pomonaFactory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em) {
		em.close();
	}
}
