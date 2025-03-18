package linear_and_binary_search.binary_search;

import java.util.Scanner;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the sorted array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target element to find: ");
        int target = scanner.nextInt();

        int[] result = findFirstAndLastOccurrence(arr, target);
        if (result[0] == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("First occurrence: " + result[0]);
            System.out.println("Last occurrence: " + result[1]);
        }
        scanner.close();
    }

    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int[] result = new int[2];
        result[0] = findFirstOccurrence(arr, target);
        result[1] = findLastOccurrence(arr, target);
        return result;
    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                firstIndex = mid; // Found target, but continue searching left
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstIndex;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                lastIndex = mid; // Found target, but continue searching right
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastIndex;
    }
}
