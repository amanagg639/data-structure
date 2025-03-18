package linear_and_binary_search.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class MissingPositiveAndBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("The first missing positive integer is: " + missingPositive);

        System.out.print("Enter the target value to search for: ");
        int target = scanner.nextInt();
        Arrays.sort(arr); // Sort the array before binary search
        int targetIndex = binarySearch(arr, target);
        System.out.println("Target value " + (targetIndex != -1 ? "found at index: " + targetIndex : "not found."));
        scanner.close();
    }

    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}