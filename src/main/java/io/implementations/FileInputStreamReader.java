package io.implementations;

import io.FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamReader implements FileReader {

    private static final int BUF_SIZE = 8;
    private FileInputStream fis;

    public FileInputStreamReader(String filePath) throws FileNotFoundException {
        fis = new FileInputStream(new File(filePath));
    }

    @Override
    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        byte[] buf = new byte[BUF_SIZE];
        while (fis.read(buf) >= 0) {
            for (byte b : buf)
                sb.append((char) b);
            buf = new byte[BUF_SIZE];
        }
        return sb.toString().trim();
    }

    @Override
    public void close() throws IOException {
        fis.close();
    }
}
