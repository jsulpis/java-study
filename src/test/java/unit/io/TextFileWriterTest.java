package unit.io;

import io.TextFileWriter;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static unit.io.TextFileReaderTest.*;

public class TextFileWriterTest {

    @Test
    public void writeTest() throws IOException {
        assertFalse(TEST_FILE.exists());

        new TextFileWriter().write(TEST_FILE, FILE_CONTENT);

        assertEquals(FILE_CONTENT, Files.readAllLines(TEST_FILE.toPath()));
    }

    @After
    public void tearDown() throws Exception {
        Files.delete(TEST_FILE.toPath());
        Files.delete(WORK_DIR.toPath());
    }
}
