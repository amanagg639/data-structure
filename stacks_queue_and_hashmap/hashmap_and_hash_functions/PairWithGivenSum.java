package stacks_queue_and_hashmap.hashmap_and_hash_functions;

import java.util.HashMap;
import java.util.Scanner;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Boolean check = CheckPair(nums, target, n);
        System.out.println(check);
    }

    private static Boolean CheckPair(int[] nums, int target, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(map.containsKey(target-nums[i])){
               return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }
}
