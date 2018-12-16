import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

class Main {
    private static final org.hibernate.SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration()
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static Session getSession() throws org.hibernate.HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        try (var session = getSession()) {
            System.out.println("querying all the managed entities...");
            final var metamodel = session.getSessionFactory().getMetamodel();
            metamodel.getEntities().stream()
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