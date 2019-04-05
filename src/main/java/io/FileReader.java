package io;

import java.io.IOException;

public interface FileReader {

    String read() throws IOException;

    void close() throws IOException;
}
