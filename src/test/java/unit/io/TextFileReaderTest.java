package unit.io;

import io.TextFileReader;
import io.TextFileWriter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public abstract class TextFileReaderTest {

    static final File WORK_DIR = new File("tmp");
    private static final String FILE_NAME = "test.txt";
    private static final int FILE_SIZE = 100;

    static final File TEST_FILE = new File(WORK_DIR, FILE_NAME);
    static final List<String> FILE_CONTENT = Arrays.asList(RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2), RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2));

    protected TextFileReader fileReader;

    @Before
    public void setUp() throws IOException {
        new TextFileWriter().write(TEST_FILE, FILE_CONTENT);
    }

    @Test
    public void checkTestFile() {
        assertTrue(TEST_FILE.exists());
    }

    @Test
    public void shouldThrowExceptionWhenFileIncorrect() {
        try {
            fileReader.read("wrongFileName");
            fail();
        } catch (FileNotFoundException | NoSuchFileException e) {
            // Expected behaviour
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void shouldReturnCorrectContent() throws IOException {
        assertEquals(FILE_CONTENT, fileReader.read(TEST_FILE.getPath()));
    }

    @After
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void tearDown() {
        TEST_FILE.delete();
        WORK_DIR.delete();
    }
}
