package unit.io.impl;

import io.impl.FilesReader;
import org.junit.Before;
import unit.io.TextFileReaderTest;

import java.io.IOException;

public class FilesReaderTest extends TextFileReaderTest {

    @Override
    @Before
    public void setUp() throws IOException {
        super.setUp();
        fileReader = new FilesReader();
    }
}
