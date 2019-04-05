package io.implementations;

import io.FileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamReader implements FileReader {

    private FileInputStream fis;

    public FileInputStreamReader(String filePath) throws FileNotFoundException {
        fis = new FileInputStream(new File(filePath));
    }

    @Override
    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = fis.read()) != -1) {
            sb.append((char) c);
        }
        return sb.toString();
    }

    @Override
    public void close() throws IOException {
        fis.close();
    }
}
