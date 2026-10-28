import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main  {
    public static void copyTextFile(String sourceName, String destPath) {
        Path source = Paths.get(sourceName);
        Path destination = Paths.get(destPath);
        if (Files.isDirectory(destination)) {
            destination = destination.resolve(source.getFileName());
        }
        try (BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8);
             BufferedWriter writer = Files.newBufferedWriter(destination, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Копирование завершено: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        copyTextFile("input.txt", "C:/temp/copy.txt");
    }
}