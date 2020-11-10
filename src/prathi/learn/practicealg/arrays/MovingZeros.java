package prathi.learn.practicealg.arrays;

public class MovingZeros {

    public static void main(String[] args) {

        int nums[] = new int[]{0, 0, 1, 0, 0};
        moveZeroes(nums);

        for (int num: nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 1)
            return;

        int start = 0;
        int end = 0;

        while(end < nums.length) {

            if(nums[end] != 0) {
                swap(nums, start, end);
                start++;
                end++;
            } else {
                end++;
            }
        }

        while(start < nums.length) {
            nums[start] = 0;
            start++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
