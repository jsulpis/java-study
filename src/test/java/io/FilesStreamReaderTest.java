package io;

import io.impl.FilesStreamReader;
import org.junit.Before;

public class FilesStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        fileReader = new FilesStreamReader();
    }
}
