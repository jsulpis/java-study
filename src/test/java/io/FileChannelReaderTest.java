package io;

import io.impl.FileChannelReader;
import org.junit.Before;

public class FileChannelReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        fileReader = new FileChannelReader();
    }
}
