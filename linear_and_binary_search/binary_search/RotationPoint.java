package linear_and_binary_search.binary_search;

import java.util.Scanner;

public class RotationPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the rotated sorted array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int rotationIndex = findRotationPoint(arr);
        System.out.println("The rotation point (index of the smallest element) is: " + rotationIndex);
        scanner.close();
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1; // Smallest element is in the right half
            } else {
                right = mid; // Smallest element is in the left half
            }
        }
        return left; // The rotation point
    }
}
