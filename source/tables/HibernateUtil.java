package logic;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static SessionFactory factory = null;
	static {
		ServiceRegistry serviceRegistry = null;
		Configuration configuration = new Configuration();
		try {
			configuration.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.configure().getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);

		} catch (HibernateException ex) {
			System.out.println(ex.toString());
			System.exit(0);
		}
	}
	
    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
