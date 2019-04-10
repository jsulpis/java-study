package io.impl;

import io.TextFileReader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Wrapper for the BufferedInputStream class in java.io.
 * <p>
 * This class improves the performance of another input stream (in this case a FileInputStream) by using a buffer array.
 */
public class BufferedInputStreamReader extends TextFileReader {

    @Override
    public List<String> read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            readStreamWithByteArray(sb, bis);
        }
        return convertStringBuilderToListOfStrings(sb);
    }
}
