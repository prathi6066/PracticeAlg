package prathi.learn.practicealg.patterns.slidingwindow;

public class ReplacingOnes {

    /*
    Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

    Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
    Output: 6
    Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

    Time: O(N) Space: O(1)
     */

    public static int findLength(int[] arr, int k) {
        // TODO: Write your code here
        int onesCount = 0;
        int start = 0;
        int len = 0;

        for (int end = 0; end< arr.length; end++) {
            if (arr[end] == 1)
                onesCount++;

            if (end - start +1 - onesCount > k) {
                if (arr[start] == 1)
                    onesCount--;
                start++;
            }

            len = Math.max(len, end-start+1);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
