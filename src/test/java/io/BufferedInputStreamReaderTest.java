package io;

import io.impl.BufferedInputStreamReader;
import org.junit.Before;

public class BufferedInputStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        fileReader = new BufferedInputStreamReader();
    }
}
