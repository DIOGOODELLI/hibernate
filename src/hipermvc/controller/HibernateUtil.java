package hipermvc.controller;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
    private static SessionFactory sessionFactory;
    
    static 
    {
        try 
        {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
            configuration.getProperties()).build();
            sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
        } 
        catch (HibernateException ex) 
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
}
