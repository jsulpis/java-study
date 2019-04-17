package io.impl;

import io.TextFileReader;

import java.io.IOException;
import java.util.List;

/**
 * Wrapper for the FileReader class in java.unit.io.
 * <p>
 * This class itself extends the InputStreamReader class. It uses a FileInputStream and a StreamDecoder
 * to convert the bytes into characters.
 */
public class FileReader extends TextFileReader {

    @Override
    public List<String> read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (java.io.FileReader fr = new java.io.FileReader(filePath)) {
            readStreamWithCharArray(sb, fr);
        }
        return convertStringBuilderToListOfStrings(sb);
    }

    private void readStreamWithCharArray(StringBuilder sb, java.io.FileReader fr) throws IOException {
        char[] buf = new char[BUF_SIZE];
        while (fr.read(buf) != -1) {
            for (char c : buf)
                sb.append(c);
            buf = new char[BUF_SIZE];
        }
    }
}
