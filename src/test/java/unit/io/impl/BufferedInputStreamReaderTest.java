package unit.io.impl;

import io.impl.BufferedInputStreamReader;
import org.junit.Before;
import unit.io.TextFileReaderTest;

import java.io.IOException;

public class BufferedInputStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new BufferedInputStreamReader();
    }
}
