package io.impl;

import io.TextFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Wrapper for the Files.newInputStream method in java.nio.
 * <p>
 * The InputStream returned by this method uses a Channel (java.nio) to read bytes from a file.
 */
public class FilesStreamReader extends TextFileReader {

    public FilesStreamReader(String filePath) {
        super(filePath);
    }

    @Override
    public List<String> read() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = Files.newInputStream(Paths.get(filePath))) {
            readFileWithByteArray(sb, is);
        }
        return convertStringBuilderToListOfStrings(sb);
    }
}
