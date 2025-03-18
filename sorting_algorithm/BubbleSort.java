package sorting_algorithm;

import java.util.Scanner;

//In bubble sort we swap adjacent elements until we find the sorted array
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }
        bubbleSort(marks);
        for(int i : marks){
            System.out.print(i + " ");
        }
    }

    private static void bubbleSort(int[] marks) {
        for (int i = 0; i < marks.length-1; i++) {
            for (int j = 0; j < marks.length; j++) {
                if(marks[i]>marks[j]){
                    int temp = marks[i];
                    marks[i] = marks[j];
                    marks[j] = temp;
                }
            }
        }
    }
}
