package sorting_algorithm;

import java.util.Scanner;

public class SelectionSort {
    //In selection select every smallest element and swap it other element until we find sorted array
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int studentScores[] = new int[n];
        for(int i = 0; i < n; i++) {
            studentScores[i] = sc.nextInt();
        }
        selectionSort(studentScores);
        for(int i : studentScores){
            System.out.print(i + " ");
        }
    }

    private static void selectionSort(int[] studentScores) {
        for (int i = 0; i < studentScores.length-1; i++) {
            int min = i;
            for (int j = i+1; j < studentScores.length; j++) {
                if(studentScores[j]<studentScores[min]){
                    min = j;
                }
            }
            int temp = studentScores[min];
            studentScores[min] = studentScores[i];
            studentScores[i] = temp;
        }
    }
}
