package io;

import io.impl.FilesReader;
import org.junit.Before;

public class FilesReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        fileReader = new FilesReader();
    }
}
