package linear_and_binary_search.string_buffer;

import java.util.Scanner;

public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of strings to concatenate: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String input = scanner.nextLine();
            stringBuffer.append(input);
        }

        // Convert StringBuffer to String and print the result
        String concatenatedString = stringBuffer.toString();
        System.out.println("Concatenated string: " + concatenatedString);

    }
}
