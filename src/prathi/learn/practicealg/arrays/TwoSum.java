package prathi.learn.practicealg.arrays;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{-1, -2, -3, -4, -5 }, -8);
        for (int res: result)
            System.out.println(res);

    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0 ;i< nums.length; i++) {
            map.put(nums[i], i);

        }

        for (int i =0 ;i< nums.length; i++) {
            int numkey = target-nums[i];
            if (map.containsKey(numkey) && map.get(numkey) != i) {
                return new int[]{i, map.get(numkey)};
            }
        }

        return new int[]{-1, -1};
    }
}
