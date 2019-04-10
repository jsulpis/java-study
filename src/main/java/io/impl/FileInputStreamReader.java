package io.impl;

import io.TextFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Wrapper for the FileInputStream class in java.io.
 * <p>
 * This class provides a basic way of reading streams of raw bytes.
 */
public class FileInputStreamReader extends TextFileReader {

    @Override
    public List<String> read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            readStreamWithByteArray(sb, fis);
        }
        return convertStringBuilderToListOfStrings(sb);
    }
}
