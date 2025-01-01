package org.anudip.javaapp.utility;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HibernateUtility {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		
			Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
			
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (standardServiceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
		}
	}
}
