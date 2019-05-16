package unit.orm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import orm.dao.AuthorDao;
import orm.dao.BookDao;
import orm.model.Author;
import orm.model.Book;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static unit.orm.AuthorDaoTest.TEST_AUTHOR;

public class BookDaoTest extends DaoTest {

    private static final Book TEST_BOOK_01 = new Book("Clean Code", TEST_AUTHOR, new Date(2008, 7, 17));
    private static final Book TEST_BOOK_02 = new Book("Clean Architecture", TEST_AUTHOR, new Date(2017, 1, 1));

    private BookDao dao;
    private AuthorDao authorDao;

    @Before
    public void setUpTest() {
        dao = new BookDao(sessionFactory);
        authorDao = new AuthorDao(sessionFactory);

        authorDao.insertOne(TEST_AUTHOR);
    }

    @After
    public void tearDownTest() {
        dao.deleteAll();
        authorDao.deleteAll();
    }

    @Test
    public void insertAndGetOneTest() {
        dao.insertAll(Arrays.asList(TEST_BOOK_01, TEST_BOOK_02));

        Book result = dao.getOneByTitle(TEST_BOOK_02.getTitle());

        assertThat(result).isEqualToComparingFieldByField(TEST_BOOK_02);
    }

    @Test
    public void insertAndGetAllTest() {
        dao.insertAll(Arrays.asList(TEST_BOOK_01, TEST_BOOK_02));

        List<Book> queryResult = dao.getAll();

        assertThat(queryResult).hasSize(2);
        assertThat(queryResult.get(0)).isEqualToComparingFieldByField(TEST_BOOK_01);
        assertThat(queryResult.get(1)).isEqualToComparingFieldByField(TEST_BOOK_02);
    }

    @Test
    public void updateOneTest() {
        dao.insertOne(TEST_BOOK_01);
        Book queryResult = dao.getOneByTitle(TEST_BOOK_01.getTitle());

        queryResult.setTitle("New Title");
        dao.updateOne(queryResult);

        assertThat(dao.getOneByTitle("New Title")).isNotNull();
    }

    @Test
    public void deleteOneTest() {
        dao.insertOne(TEST_BOOK_01);
        assertThat(dao.getOneByTitle(TEST_BOOK_01.getTitle())).isEqualToComparingFieldByField(TEST_BOOK_01);

        dao.deleteOne(TEST_BOOK_01);

        assertThat(dao.getAll()).isEmpty();
    }

    @Test
    public void deleteAllTest() {
        dao.insertAll(Arrays.asList(TEST_BOOK_01, TEST_BOOK_02));
        dao.deleteAll();
        assertThat(dao.getAll()).isEmpty();
    }

    @Test
    public void objectAttributeTest() {
        dao.insertOne(TEST_BOOK_01);

        Author author = dao.getOneByTitle(TEST_BOOK_01.getTitle()).getAuthor();

        assertThat(author).isEqualToComparingFieldByField(TEST_AUTHOR);
    }
}
