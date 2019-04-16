package io;

import io.impl.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileIOBenchmark {

    private static final Logger LOG = LoggerFactory.getLogger(FileIOBenchmark.class);
    public static final File WORK_DIR = new File("tmp");
    private static final String FILE_NAME = "test.txt";
    private static final int FILE_SIZE = 5000000;

    private static final File TEST_FILE = new File(WORK_DIR, FILE_NAME);
    private static final List<String> FILE_CONTENT = Arrays.asList(RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2), RandomStringUtils.randomAlphanumeric(FILE_SIZE / 2));

    public static void main(String[] args) throws IOException {
        writeTestFile();

        List<TextFileReader> algorithms = Arrays.asList(new FileInputStreamReader(), new BufferedInputStreamReader(), new FilesReader(), new FileReader(), new FilesStreamReader(), new FileChannelReader());

        runBenchmark(algorithms);
        cleanWorkDir();
    }

    private static void cleanWorkDir() throws IOException {
        Files.delete(TEST_FILE.toPath());
        Files.delete(WORK_DIR.toPath());
    }

    private static void writeTestFile() throws IOException {
        new TextFileWriter().write(TEST_FILE, FILE_CONTENT);
    }

    private static void runBenchmark(List<TextFileReader> fileReaders) throws IOException {
        printHeader();
        for (TextFileReader fileReader : fileReaders) {
            long startTime = System.currentTimeMillis();
            fileReader.read(TEST_FILE.getPath());
            formatAndLogString("%25s %17s", fileReader.getClass().getSimpleName(), (System.currentTimeMillis() - startTime));
        }
    }

    private static void printHeader() {
        LOG.info("Running the benchmark on a file of {} characters.", FILE_SIZE);

        LOG.info("--------------------------------------------------");
        formatAndLogString("%20s %25s", "ALGO", "TIME(ms)");
        LOG.info("--------------------------------------------------");
    }

    private static void formatAndLogString(String rawString, Object... params) {
        String formattedString = String.format(rawString, params);
        LOG.info(formattedString);
    }
}
