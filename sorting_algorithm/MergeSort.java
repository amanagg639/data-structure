package sorting_algorithm;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bookPrices = new int[n];
        for (int i = 0; i < n; i++) {
            bookPrices[i] = sc.nextInt();
        }
        mergeSort(bookPrices, 0, n-1);
        for(int i : bookPrices){
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] bookPrices, int l, int r) {
        if(l<r) {
            int m = (l + r) / 2;
            mergeSort(bookPrices, l, m);
            mergeSort(bookPrices, m + 1, r);
            merge(bookPrices, l, m, r);
        }
    }

    private static void merge(int[] bookPrices, int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int a1[] = new int[n1];
        int a2[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            a1[i] = bookPrices[i+l];
        }
        for (int i = 0; i < n2; i++) {
            a2[i] = bookPrices[m+1+i];

        }
        int i=0, j=0;
        int index = l;
        while (i<n1 && j<n2){
            if(a1[i]<=a2[j]){
                bookPrices[index++] = a1[i];
                i++;
            }
            else{
                bookPrices[index++] = a2[j];
                j++;
            }
        }
        while (i<n1){
            bookPrices[index++] = a1[i++];
        }
        while (j<n2){
            bookPrices[index++] = a2[j++];
        }
    }
}
