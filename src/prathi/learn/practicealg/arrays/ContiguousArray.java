package prathi.learn.practicealg.arrays;

import java.util.HashMap;

public class ContiguousArray {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {0, 1, 0, 1}));
    }

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = 0;
        int currentSum = 0;
        map.put(0, -1);

        for (int i=0; i< nums.length; i++) {
            currentSum += nums[i] == 0 ? -1 : nums[i];

            if (map.containsKey(currentSum)) {
                maxSum = Math.max(maxSum, i-map.get(currentSum));
            } else {
                map.put(currentSum, i);
            }
        }

        return maxSum;

    }
}
