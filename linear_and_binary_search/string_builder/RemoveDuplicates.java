package linear_and_binary_search.string_builder;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to remove duplicates: ");
        String input = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Character> seenCharacters = new HashSet<>();

        for (char c : input.toCharArray()) {
            // If the character is not in the HashSet, add it
            if (!seenCharacters.contains(c)) {
                seenCharacters.add(c);
                stringBuilder.append(c);
            }
        }

        String resultString = stringBuilder.toString();
        System.out.println("String without duplicates: " + resultString);

    }
}
