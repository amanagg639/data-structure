package linear_and_binary_search.input_stream_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CompareStringAndFileReaders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // StringBuilder and StringBuffer comparison
        String str = "hello";
        int iterations = 1_000_000;

        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        System.out.println("Time taken by StringBuilder: " + durationBuilder + " nanoseconds");
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " nanoseconds");

        // FileReader and InputStreamReader comparison
        System.out.print("Enter the path of the large file to read: ");
        String filePath = scanner.nextLine();

        long startTimeFileReader = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split by whitespace
            }
            long endTimeFileReader = System.nanoTime();
            long durationFileReader = endTimeFileReader - startTimeFileReader;
            System.out.println("Word count using FileReader: " + wordCount);
            System.out.println("Time taken by FileReader: " + durationFileReader + " nanoseconds");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Measure time for InputStreamReader
        long startTimeInputStreamReader = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(Paths.get(filePath)));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            int wordCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Split by whitespace
            }
            long endTimeInputStreamReader = System.nanoTime();
            long durationInputStreamReader = endTimeInputStreamReader - startTimeInputStreamReader;
            System.out.println("Word count using InputStreamReader: " + wordCount);
            System.out.println("Time taken by InputStreamReader: " + durationInputStreamReader + " nanoseconds");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

    }
}
