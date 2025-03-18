package sorting_algorithm;

import java.util.Scanner;
//In insertion sort we put each element of unsorted list into its correct position in sorted list
public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] employeeId = new int[n];
        for (int i = 0; i < n; i++) {
            employeeId[i] = sc.nextInt();
        }
        insertionSort(employeeId);
        for(int i : employeeId){
            System.out.print(i + " ");
        }
    }

    private static void insertionSort(int[] employeeId) {
        for (int i = 1; i < employeeId.length; i++) {
            int key = employeeId[i];
            int j = i-1;
            while(j>=0 && employeeId[j]>key){
                employeeId[j+1] = employeeId[j];
                j = j-1;
            }
            employeeId[j+1] = key;
        }
    }

}
