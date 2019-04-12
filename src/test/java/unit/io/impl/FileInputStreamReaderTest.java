package unit.io.impl;

import io.impl.FileInputStreamReader;
import org.junit.Before;
import unit.io.TextFileReaderTest;

import java.io.IOException;

public class FileInputStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FileInputStreamReader();
    }
}
