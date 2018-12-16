import org.hibernate.HibernateException;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.metamodel.EntityType;

public class Main {
    private static final org.hibernate.SessionFactory ourSessionFactory;

    static {
        // A SessionFactory is set up once for an application!
        final var registry = new StandardServiceRegistryBuilder()
                .configure()
                // configures settings from hibernate.cfg.xml
                .build();
        try {
            ourSessionFactory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static org.hibernate.Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        try (var session = getSession()) {
            System.out.println("querying all the managed entities...");
            final var metaModel = session.getSessionFactory().getMetamodel();
            metaModel
                    .getEntities()
                    .stream()
                    .map(EntityType::getName)
                    .map(entityName -> session.createQuery("from " + entityName))
                    .forEach(query -> {
                        System.out.println("executing: " + query.getQueryString());
                        for (var o : query.list())
                            System.out.println("  " + o);
                    });
        }
    }
}