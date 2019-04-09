package io;

import io.impl.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextFileReaderTest {

    private static final String WORK_DIR = System.getProperty("java.io.tmpdir");
    private static final String FILE_NAME = "test.txt";
    private static final String FILE_PATH = WORK_DIR + "\\" + FILE_NAME;
    private static final int FILE_SIZE = 100;
    private static final List<String> FILE_CONTENT = Arrays.asList(RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2), RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2));

    @Before
    public void setUp() throws Exception {
        FileWriter writer = new FileWriter(FILE_PATH);
        for (String line : FILE_CONTENT) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    @Test
    public void fisReaderTest() throws IOException {
        testFileReader(new FileInputStreamReader(FILE_PATH));
    }

    @Test
    public void bisReaderTest() throws IOException {
        testFileReader(new BufferedInputStreamReader(FILE_PATH));
    }

    @Test
    public void fileReaderTest() throws IOException {
        testFileReader(new FileReader(FILE_PATH));
    }

    @Test
    public void filesReaderTest() throws IOException {
        testFileReader(new FilesReader(FILE_PATH));
    }

    @Test
    public void filesStreamReaderTest() throws IOException {
        testFileReader(new FilesStreamReader(FILE_PATH));
    }

    @Test
    public void fileChannelReaderTest() throws IOException {
        testFileReader(new FileChannelReader(FILE_PATH));
    }

    private void testFileReader(TextFileReader fileReader) throws IOException {
        assertEquals(FILE_CONTENT, fileReader.read());
    }

    @After
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void tearDown() {
        new File(FILE_PATH).delete();
    }
}
