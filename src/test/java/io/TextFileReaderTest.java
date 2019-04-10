package io;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public abstract class TextFileReaderTest {

    private static final String WORK_DIR = System.getProperty("java.io.tmpdir");
    private static final String FILE_NAME = "test.txt";
    private static final String FILE_PATH = WORK_DIR + "\\" + FILE_NAME;
    private static final int FILE_SIZE = 100;
    private static final List<String> FILE_CONTENT = Arrays.asList(RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2), RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2));

    TextFileReader fileReader;

    @Before
    public void setUp() throws Exception {
        FileWriter writer = new FileWriter(FILE_PATH);
        for (String line : FILE_CONTENT) {
            writer.write(line + "\n");
        }
        writer.close();
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
        assertEquals(FILE_CONTENT, fileReader.read(FILE_PATH));
    }

    @After
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void tearDown() {
        new File(FILE_PATH).delete();
    }
}
