package sorting_algorithm;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []salaries = new int[n];
        for(int i=0; i<n; i++){
            salaries[i] = scanner.nextInt();
        }
        heapSort(salaries);
        for(int salary : salaries){
            System.out.print(salary + " ");
        }
    }

    private static void heapSort(int[] salaries) {
        int n = salaries.length;
        for(int i=n/2-1; i>=0; i--){
            heapify(salaries, n, i);
        }
        for (int i = n-1; i>0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    private static void swap(int[] salaries, int i, int j) {
        int temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }

    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && salaries[l]>salaries[largest]){
            largest = l;
        }
        if(r<n && salaries[r]>salaries[largest]){
            largest = r;
        }
        if(largest != i){
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }
}
