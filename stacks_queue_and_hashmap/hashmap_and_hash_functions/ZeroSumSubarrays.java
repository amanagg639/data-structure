package stacks_queue_and_hashmap.hashmap_and_hash_functions;

import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        List<int[]> ls = findSubarrays(nums);
        for(int []range : ls){
            System.out.println("start: " + range[0] + ", End: " + range[1]);
        }
    }

    private static List<int[]> findSubarrays(int[] nums) {
        List<int[]> ls = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum)){
                for(int start : map.get(sum)){
                    ls.add(new int[]{start+1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return ls;
    }
}
