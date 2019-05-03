package springboot.io.impl;

import io.impl.FilesReader;
import org.junit.Before;
import springboot.io.TextFileReaderTest;

import java.io.IOException;

public class FilesReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FilesReader();
    }
}
