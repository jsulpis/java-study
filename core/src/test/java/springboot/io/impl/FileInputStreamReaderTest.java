package springboot.io.impl;

import io.impl.FileInputStreamReader;
import org.junit.Before;
import springboot.io.TextFileReaderTest;

import java.io.IOException;

public class FileInputStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FileInputStreamReader();
    }
}
