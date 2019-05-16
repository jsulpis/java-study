package unit.orm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import orm.dao.AuthorDao;
import orm.model.Author;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorDaoTest extends DaoTest {

    static final Author TEST_AUTHOR = new Author("Robert", "C. Martin");

    private AuthorDao dao;

    @Before
    public void setUpTest() {
        dao = new AuthorDao(sessionFactory);
    }

    @After
    public void tearDownTest() {
        dao.deleteAll();
    }

    @Test
    public void insertOneTest() {
        dao.insertOne(TEST_AUTHOR);

        assertThat(dao.getOneById(1)).isEqualToComparingFieldByField(TEST_AUTHOR);
    }

    @Test
    public void deleteAllTest() {
        dao.insertOne(TEST_AUTHOR);

        dao.deleteAll();

        assertThat(dao.getOneById(1)).isNull();
    }
}
