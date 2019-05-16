package orm.dao;

import org.hibernate.SessionFactory;
import orm.model.Author;

public class AuthorDao extends HibernateDao {

    public AuthorDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertOne(Author author) {
        executeVoidOperation(session -> session.save(author));
    }

    public Author getOneById(long id) {
        return executeOperation(session -> session.get(Author.class, id));
    }

    public void deleteAll() {
        executeVoidOperation(session -> session.createQuery("delete from Author").executeUpdate());
    }
}
