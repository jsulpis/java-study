package unit.io;

import io.FileIOBenchmark;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileIOBenchmarkTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpSystemOut() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void benchmarkShouldLogSomethingAndDeleteWorkDir() throws IOException {
        FileIOBenchmark.main(null);
        assertThat(outContent.toString()).isNotBlank();
        assertThat(FileIOBenchmark.WORK_DIR.exists()).isFalse();
    }

    @After
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }
}
