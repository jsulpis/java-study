package springboot.io.impl;

import io.impl.FileChannelReader;
import org.junit.Before;
import springboot.io.TextFileReaderTest;

import java.io.IOException;

public class FileChannelReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FileChannelReader();
    }
}
