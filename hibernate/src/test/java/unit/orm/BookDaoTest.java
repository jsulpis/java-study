package unit.orm;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import orm.Book;
import orm.BookDao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookDaoTest {

    private final Book TEST_BOOK_01 = new Book("Clean Code", "Robert C. Martin", new Date(2008, 7, 17));
    private final Book TEST_BOOK_02 = new Book("Clean Architecture", "Robert C. Martin", new Date(2017, 1, 1));

    private BookDao dao;
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            dao = new BookDao(sessionFactory);
        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @After
    public void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void insertAndGetOneTest() {
        dao.insertAll(Arrays.asList(TEST_BOOK_01, TEST_BOOK_02));

        Book result = dao.getOneById(2);

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
        Book queryResult = dao.getOneById(1);
        assertThat(queryResult).isEqualToComparingFieldByField(TEST_BOOK_01);

        Book modifiedBook = new Book(TEST_BOOK_01.getTitle() + "-UPDATED", TEST_BOOK_01.getAuthor(), TEST_BOOK_01.getReleaseDate());
        modifiedBook.setId(1);
        dao.updateOne(modifiedBook);

        assertThat(dao.getOneById(1)).isEqualToComparingFieldByField(modifiedBook);
    }

    @Test
    public void deleteOneTest() {
        dao.insertOne(TEST_BOOK_01);
        assertThat(dao.getOneById(1)).isEqualToComparingFieldByField(TEST_BOOK_01);

        dao.deleteOne(TEST_BOOK_01);

        assertThat(dao.getAll()).isEmpty();
    }
}
