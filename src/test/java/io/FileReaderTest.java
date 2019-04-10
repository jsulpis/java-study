package io;

import io.impl.FileReader;
import org.junit.Before;

public class FileReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        fileReader = new FileReader();
    }
}
