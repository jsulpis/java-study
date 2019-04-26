package io.impl;

import io.TextFileReader;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.List;

/**
 * Wrapper for reading a file using a FileChannel (java.nio).
 */
public class FileChannelReader extends TextFileReader {

    @Override
    public List<String> read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (FileChannel fc = FileChannel.open(Paths.get(filePath))) {
            readStreamWithByteBuffer(sb, fc);
        }
        return convertStringBuilderToListOfStrings(sb);
    }

    private void readStreamWithByteBuffer(StringBuilder sb, FileChannel fc) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(BUF_SIZE);
        while (fc.read(buf) != -1) {
            for (byte b : buf.array())
                sb.append((char) b);
            buf.clear();
        }
    }
}
