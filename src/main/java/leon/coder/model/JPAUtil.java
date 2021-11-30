package leon.coder.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String PERSISTENCE_UNIT_NANE= "PERSISTENCE";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory gEntityManagerFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NANE);
		}
		
		return factory;
	}
	
	public static void shutDown() {
		if (factory != null) {
			factory.close();
		}
	}
}
