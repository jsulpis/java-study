package unit.io.impl;

import io.impl.FilesStreamReader;
import org.junit.Before;
import unit.io.TextFileReaderTest;

import java.io.IOException;

public class FilesStreamReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FilesStreamReader();
    }
}
