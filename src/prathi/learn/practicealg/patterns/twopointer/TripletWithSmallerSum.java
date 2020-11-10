package prathi.learn.practicealg.patterns.twopointer;

import java.util.Arrays;

public class TripletWithSmallerSum {

    /*
    Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

    Input: [-1, 0, 2, 3], target=3
    Output: 2
    Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
     */

    public static int searchTriplets(int[] arr, int target) {
        // TODO: Write your code here
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += findPairs(arr, i+1, target - arr[i]);
        }
        return count;
    }

    private static int findPairs(int[] arr, int left, int target) {
        int count = 0;
        int right = arr.length-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                count+= right- left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
