package io;

import io.impl.FileInputStreamReader;
import org.junit.Before;

public class FileInputStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        fileReader = new FileInputStreamReader();
    }
}
