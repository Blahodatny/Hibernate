import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import retail.Customer;

import javax.persistence.metamodel.EntityType;

class Main {
    private static final SessionFactory SESSION_FACTORY;

    static {
        // A SessionFactory is set up once for an application!
        final var REGISTRY = new StandardServiceRegistryBuilder()
                .configure()
                // configures settings from hibernate.cfg.xml
                .build();
        try {
            SESSION_FACTORY = new MetadataSources(REGISTRY)
                    .buildMetadata().buildSessionFactory();
        } catch (HibernateException ex) {
            StandardServiceRegistryBuilder.destroy(REGISTRY);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(final String[] args) {
        try (var session = SESSION_FACTORY.openSession()) {
            System.out.println("querying all the managed entities...");
            session
                    .getSessionFactory()
                    .getMetamodel()
                    .getEntities()
                    .stream()
                    .map(EntityType::getName)
                    .map(entityName -> session.createQuery("from " + entityName))
                    .forEach(query -> {
                        System.out.println("executing: " + query.getQueryString());
                        for (var o : query.list())
                            System.out.println("  " + o);
                    });
            var tx = session.beginTransaction();
            session.save(new Customer(
                    "+380-98-456-43-54",
                    "Dima",
                    "Pochta",
                    "Vasila St.",
                    "Warsaw"
            ));
            tx.commit();
            session.close();
        }
    }
}