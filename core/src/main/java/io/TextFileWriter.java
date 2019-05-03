package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * This class is just used to provide testing material for the reading methods.
 * <p>
 * I assume the performance of the writing methods are similar to there equivalent for reading,
 * therefore I studied only the readers.
 */
public class TextFileWriter {

    public void write(File file, List<String> lines) throws IOException {
        File parent = file.getParentFile();
        if (!parent.exists())
            Files.createDirectory(parent.toPath());

        Path filePath = file.toPath();
        String fileContent = getFileContentString(lines);
        Files.write(filePath, fileContent.getBytes());
    }

    private String getFileContentString(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines)
            sb.append(line).append("\n");
        return sb.toString();
    }
}
