package orm.dao;

import org.hibernate.SessionFactory;
import orm.model.Book;

import java.util.List;

public class BookDao extends HibernateDao {

    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertOne(Book book) {
        executeVoidOperation(session -> session.save(book));
    }

    public void insertAll(List<Book> books) {
        executeVoidOperation(session -> {
            for (Book book : books)
                session.save(book);
        });
    }

    public Book getOneByTitle(String title) {
        return executeOperation(session -> session.createQuery("from Book b where b.title = :title", Book.class)
                .setParameter("title", title)
                .getSingleResult());
    }

    public List<Book> getAll() {
        return executeOperation(session -> session.createQuery("from orm.model.Book", Book.class).list());
    }

    public void updateOne(Book modifiedBook) {
        executeVoidOperation(session -> session.update(modifiedBook));
    }

    public void deleteOne(Book book) {
        executeVoidOperation(session -> session.delete(book));
    }

    public void deleteAll() {
        executeVoidOperation(session -> session.createQuery("delete from Book").executeUpdate());
    }
}
