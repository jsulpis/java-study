package orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao {
    private SessionFactory sessionFactory;

    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertOne(Book book) {
        Session session = openSessionWithTransaction();
        session.save(book);
        commitAndClose(session);
    }

    public void insertAll(List<Book> books) {
        Session session = openSessionWithTransaction();
        for (Book book : books)
            session.save(book);
        commitAndClose(session);
    }

    public Book getOneById(long id) {
        Session session = openSessionWithTransaction();
        Book result = session.get(Book.class, id);
        commitAndClose(session);
        return result;
    }

    public List<Book> getAll() {
        Session session = openSessionWithTransaction();
        List<Book> result = session.createQuery("from orm.Book", Book.class).list();
        commitAndClose(session);
        return result;
    }

    public void updateOne(Book modifiedBook) {
        Session session = openSessionWithTransaction();
        session.update(modifiedBook);
        commitAndClose(session);
    }

    public void deleteOne(Book book) {
        Session session = openSessionWithTransaction();
        session.delete(book);
        commitAndClose(session);
    }

    private Session openSessionWithTransaction() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    private void commitAndClose(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
