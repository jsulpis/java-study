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

    @Override
    public List<String> read(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
