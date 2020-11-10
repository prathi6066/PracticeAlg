package prathi.learn.practicealg.arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(getSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num: nums) {
            currentSum +=num;

            if (currentSum < num)
                currentSum = num;

            if (currentSum > sum)
                sum = currentSum;
        }

        return sum;

    }

    public static int getSum(int[] array) {
        int maxNum = array[0];
        int currSum = array[0];
        for (int i = 1; i < array.length; i++) {
            currSum = Math.max(currSum + array[i], array[i]);
            maxNum = Math.max(currSum, maxNum);
        }

        return maxNum;
    }
}
