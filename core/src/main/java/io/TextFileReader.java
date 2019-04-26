package io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * An abstract representation of a text file reader.
 */
public abstract class TextFileReader {

    protected static final int BUF_SIZE = 8192;

    /**
     * Reads all the lines of the text file.
     *
     * @return a list of Strings, each containing a line of the file.
     * @throws IOException if any I/O error occurs.
     */
    public abstract List<String> read(String filePath) throws IOException;

    protected void readStreamWithByteArray(StringBuilder sb, InputStream is) throws IOException {
        byte[] buf = new byte[BUF_SIZE];
        while (is.read(buf) != -1) {
            for (byte b : buf)
                sb.append((char) b);
            buf = new byte[BUF_SIZE];
        }
    }

    protected List<String> convertStringBuilderToListOfStrings(StringBuilder sb) {
        String fileContent = sb.toString().trim();
        return Arrays.asList(fileContent.split("\n"));
    }
}
