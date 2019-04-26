package springboot.io.impl;

import io.impl.FileReader;
import org.junit.Before;
import springboot.io.TextFileReaderTest;

import java.io.IOException;

public class FileReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FileReader();
    }
}
