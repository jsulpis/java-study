package unit.sorting;

import org.junit.After;
import org.junit.Test;
import sorting.ListSortingBenchmark;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class ListSortingBenchmarkTest {

    private static final File LOG_FILE = new File("./src/test/resources/app-test.log");

    @Test
    public void benchmarkShouldLogSomething() throws IOException {
        final String expectedLogLevel = "INFO ";
        final String expectedBenchmarkTitle = "### Benchmark of the speed of various sorting algorithms ###";
        final String expectedLogRow = String.format("[%s] - %s", expectedLogLevel, expectedBenchmarkTitle);

        ListSortingBenchmark.main(null);

        assertThat(Files.readAllLines(LOG_FILE.toPath())).contains(expectedLogRow);
    }

    @After
    public void deleteLogFile() {
        LOG_FILE.deleteOnExit();
    }
}
