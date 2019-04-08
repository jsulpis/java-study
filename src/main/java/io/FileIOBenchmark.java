package io;

import io.implementations.FileInputStreamReader;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileIOBenchmark {
    private static final String WORK_DIR = System.getProperty("java.io.tmpdir");
    private static final String FILE_NAME = "test.txt";
    private static final String FILE_PATH = WORK_DIR + "\\" + FILE_NAME;
    private static final int FILE_SIZE = 1000000;
    private static final String FILE_CONTENT = RandomStringUtils.randomAlphanumeric(FILE_SIZE);

    public static void main(String[] args) throws IOException {
        writeTestFile();
        List<FileReader> algorithms = Arrays.asList(new FileInputStreamReader(FILE_PATH));

        runBenchmark(algorithms);
    }

    private static void writeTestFile() throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(FILE_CONTENT);
        writer.close();
    }

    private static void runBenchmark(List<FileReader> algorithms) throws IOException {
        printHeader();
        for (FileReader reader : algorithms) {
            long startTime = System.currentTimeMillis();
            reader.read();
            System.out.format("%25s %17s", reader.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
            System.out.println();
            reader.close();
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
