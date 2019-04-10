package io;

import io.impl.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileIOBenchmark {
    private static final String WORK_DIR = System.getProperty("java.io.tmpdir");
    private static final String FILE_NAME = "test.txt";
    private static final String FILE_PATH = WORK_DIR + "\\" + FILE_NAME;
    private static final int FILE_SIZE = 50000000;
    private static final String FILE_CONTENT = RandomStringUtils.randomAlphanumeric(FILE_SIZE);

    public static void main(String[] args) throws IOException {
        writeTestFile();
        List<TextFileReader> algorithms = Arrays.asList(new FileInputStreamReader(), new BufferedInputStreamReader(), new FilesReader(), new FileReader(), new FilesStreamReader(), new FileChannelReader());

        runBenchmark(algorithms);
    }

    private static void writeTestFile() throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(FILE_CONTENT);
        writer.close();
    }

    private static void runBenchmark(List<TextFileReader> fileReaders) throws IOException {
        printHeader();
        for (TextFileReader fileReader : fileReaders) {
            long startTime = System.currentTimeMillis();
            fileReader.read(FILE_PATH);
            System.out.format("%25s %17s", fileReader.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
            System.out.println();
        }
    }

    private static void printHeader() {
        System.out.println(String.format("Lecture d'un fichier de %d elements", FILE_SIZE));

        System.out.println("--------------------------------------------------");
        System.out.printf("%20s %25s", "ALGO", "TIME(ms)");
        System.out.println();
        System.out.println("--------------------------------------------------");
    }
}
