package io.impl;

import io.TextFileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Wrapper for the Files.readAllLines method in java.nio.
 * <p>
 * This method uses a BufferedReader internally.
 */
public class FilesReader extends TextFileReader {

    public FilesReader(String filePath) {
        super(filePath);
    }

    @Override
    public List<String> read() throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
