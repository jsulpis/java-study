package unit.io;

import io.FileIOBenchmark;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class FileIOBenchmarkTest {

    private static final File LOG_FILE = new File("./src/test/resources/app-test.log");

    /**
     * I made a single test to avoid repeated I/O operations.
     *
     * @throws IOException if any IO error occurs.
     */
    @Test
    public void benchmarkShouldLogSomethingAndDeleteWorkDirOnExit() throws IOException {
        final String expectedLogLevel = "INFO ";
        final String expectedBenchmarkTitle = "### Benchmark of the reading speed of various java objects ###";
        final String expectedLogRow = String.format("[%s] - %s", expectedLogLevel, expectedBenchmarkTitle);

        FileIOBenchmark.main(null);

        assertThat(Files.readAllLines(LOG_FILE.toPath())).contains(expectedLogRow);
        assertThat(FileIOBenchmark.WORK_DIR.exists()).isFalse();
    }

    @After
    public void deleteLogFile() {
        LOG_FILE.deleteOnExit();
    }
}
