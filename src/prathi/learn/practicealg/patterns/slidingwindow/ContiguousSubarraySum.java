package prathi.learn.practicealg.patterns.slidingwindow;

import java.util.Arrays;

public class ContiguousSubarraySum {
    //Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
    //Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    //Output: [2.2, 2.8, 2.4, 3.6, 2.8]

    public static void main(String[] args) {

        double[] result = findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }

    private static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];

        double totSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            totSum +=arr[end];

            if (end >= K -1) {
                result[start] = totSum/K;
                totSum -=arr[start];
                start++;
            }
        }

        return result;
    }
}
