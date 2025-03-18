package sorting_algorithm;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []productPrices = new int[n];
        for (int i = 0; i < n; i++) {
            productPrices[i] = scanner.nextInt();
        }
        quickSort(productPrices, 0, n-1);
        for(int i : productPrices){
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] productPrices, int l, int r) {
        if(l<r) {
            int pi = partition(productPrices, l, r);
            quickSort(productPrices, l, pi - 1);
            quickSort(productPrices, pi + 1, r);
        }
    }

    private static int partition(int[] productPrices, int l, int r) {

//        int mid = (l+r)/2;
        int pivot = productPrices[r];
        int i = l-1;
        for(int j=l; j<r; j++){
            if(productPrices[j]<pivot){
                i++;
                swap(productPrices, i, j);
            }
        }
        swap(productPrices, i+1, r);
        return i+1;
    }

    private static void swap(int[] productPrices, int i, int j) {
        int temp = productPrices[i];
        productPrices[i] = productPrices[j];
        productPrices[j] = temp;
    }
}
