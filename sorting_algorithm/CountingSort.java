package sorting_algorithm;

import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ages[] = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        countingSort(ages, 10, 18);
        for(int age : ages){
            System.out.print(age + " ");
        }
    }

    private static void countingSort(int[] ages, int min, int max) {
         int range = max-min+1;
         int count[] = new int[range];
         int output[] = new int[ages.length];
        for (int i : ages) {
            count[i-min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i-1];
        }
        for (int i = ages.length-1; i >= 0; i--) {
            output[count[ages[i]-min]-1] = ages[i];
            count[ages[i]-min]--;
        }
        System.arraycopy(output, 0, ages, 0, output.length);
    }
}
