package io;

import io.implementations.FileInputStreamReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private static final String WORK_DIR = "C:\\Users\\jsulpis\\Desktop\\java-study\\tmp";// System.getProperty("java.io.tmpdir");
    private static final String FILE_NAME = "test.txt";
    private static final String FILE_PATH = WORK_DIR + "\\" + FILE_NAME;
    private static final String FILE_CONTENT = RandomStringUtils.randomAlphanumeric(100);

    @Before
    public void setUp() throws Exception {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(FILE_CONTENT);
        writer.close();
    }

    @Test
    public void fisReaderTest() throws IOException {
        FileReader fisReader = new FileInputStreamReader(FILE_PATH);
        assertEquals(FILE_CONTENT, fisReader.read());
        fisReader.close();
    }

    @After
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void tearDown() {
        new File(FILE_PATH).delete();
    }
}
