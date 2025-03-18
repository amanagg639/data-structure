package linear_and_binary_search.linear_search;

import java.util.Scanner;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int index = findFirstNegative(array);
        if (index != -1) {
            System.out.println("The first negative number is at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }

        scanner.close();
    }

    public static int findFirstNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
