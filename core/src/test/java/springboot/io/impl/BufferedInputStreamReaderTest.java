package springboot.io.impl;

import io.impl.BufferedInputStreamReader;
import org.junit.Before;
import springboot.io.TextFileReaderTest;

import java.io.IOException;

public class BufferedInputStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new BufferedInputStreamReader();
    }
}
