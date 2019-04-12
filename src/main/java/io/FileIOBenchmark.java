package io;

import io.impl.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileIOBenchmark {
    private static final File WORK_DIR = new File("tmp");
    private static final String FILE_NAME = "test.txt";
    private static final int FILE_SIZE = 5000000;

    private static final File TEST_FILE = new File(WORK_DIR, FILE_NAME);
    private static final List<String> FILE_CONTENT = Arrays.asList(RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2), RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2));

    public static void main(String[] args) throws IOException {
        writeTestFile();

        List<TextFileReader> algorithms = Arrays.asList(new FileInputStreamReader(), new BufferedInputStreamReader(), new FilesReader(), new FileReader(), new FilesStreamReader(), new FileChannelReader());

        runBenchmark(algorithms);
    }

    private static void writeTestFile() throws IOException {
        new TextFileWriter().write(TEST_FILE, FILE_CONTENT);
    }

    private static void runBenchmark(List<TextFileReader> fileReaders) throws IOException {
        printHeader();
        for (TextFileReader fileReader : fileReaders) {
            long startTime = System.currentTimeMillis();
            fileReader.read(TEST_FILE.getPath());
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
