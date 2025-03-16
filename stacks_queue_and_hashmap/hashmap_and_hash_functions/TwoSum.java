package stacks_queue_and_hashmap.hashmap_and_hash_functions;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int[] twoSumPair = twoSum(array, target);
        for(int i : twoSumPair){
            System.out.println(i);
        }
    }

    private static int[] twoSum(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            int num = target-array[i];
            if(map.containsKey(num)){
                return new int[]{map.get(num), i};
            }
            map.put(array[i], i);
        }
        return new int[]{-1, -1};
    }
}
