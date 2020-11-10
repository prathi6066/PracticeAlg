package prathi.learn.practicealg.arrays;

import java.util.HashMap;
import java.util.Map;

public class RotateArrayKTimes {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotate2(nums, 9);

        for (int num: nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        if (k > nums.length )
            k = k % nums.length;
        if (k > 0) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(i, nums[i]);

        for (int i = 0; i < nums.length; i++)
        {
            int newPos = i + k;
            if (newPos >= nums.length)
                newPos = newPos - nums.length;
            nums[newPos] = map.get(i);
        }
    }

}
