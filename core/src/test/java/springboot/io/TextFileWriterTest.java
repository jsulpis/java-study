package springboot.io;

import io.TextFileWriter;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static springboot.io.TextFileReaderTest.*;

public class TextFileWriterTest {

    @Test
    public void writeTest() throws IOException {
        assertThat(TEST_FILE.exists()).isFalse();

        writeFileAndTestReading();
    }

    @Test
    public void writeInExistingDirectoryTest() throws IOException {
        Files.createDirectory(WORK_DIR.toPath());
        assertThat(WORK_DIR.exists()).isTrue();

        writeFileAndTestReading();
    }

    private void writeFileAndTestReading() throws IOException {
        new TextFileWriter().write(TEST_FILE, FILE_CONTENT);
        assertThat(Files.readAllLines(TEST_FILE.toPath())).isEqualTo(FILE_CONTENT);
    }

    @After
    public void tearDown() throws Exception {
        Files.delete(TEST_FILE.toPath());
        Files.delete(WORK_DIR.toPath());
    }
}
