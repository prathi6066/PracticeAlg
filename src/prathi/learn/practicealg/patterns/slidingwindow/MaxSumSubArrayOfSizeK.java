package prathi.learn.practicealg.patterns.slidingwindow;

public class MaxSumSubArrayOfSizeK {

    //Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

    /*Input: [2, 1, 5, 1, 3, 2], k=3
    Output: 9
    Explanation: Subarray with maximum sum is [5, 1, 3].*/

    //Time: O(N). Space: O(1)

    private static int findMaxSumSubArray(int k, int[] arr) {
        int totSum = 0;
        int maxSum = 0;
        int start = 0;

        for (int end = 0;end < arr.length; end++) {
            totSum +=arr[end];

            if (end >= k-1) {
                maxSum = Math.max(totSum, maxSum);
                totSum -= arr[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int res = findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 });
        System.out.println(res);
    }
}
