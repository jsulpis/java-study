package orm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Consumer;
import java.util.function.Function;

abstract class HibernateDao {

    SessionFactory sessionFactory;

    private Session openSessionWithTransaction() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    private void commitAndClose(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    <T> T executeOperation(Function<Session, T> operation) {
        Session session = openSessionWithTransaction();
        T result = operation.apply(session);
        commitAndClose(session);
        return result;
    }

    void executeVoidOperation(Consumer<Session> operation) {
        Session session = openSessionWithTransaction();
        operation.accept(session);
        commitAndClose(session);
    }
}
