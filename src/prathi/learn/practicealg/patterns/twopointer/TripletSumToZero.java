package prathi.learn.practicealg.patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    /*
    Given an array of unsorted numbers, find all unique triplets in it that add up to zero

    Input: [-3, 0, 1, 2, -1, 1, -2]
    Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
    Explanation: There are four unique triplets whose sum is equal to zero.

    Time: Sorting the array will take O(N * logN)O(N∗logN). The findTriplets() function will take O(N)O(N). As we are calling findTriplets() for every number in the input array, this means that overall searchTriplets() will take O(N * logN + N^2)O(N∗logN+N
​2
​​ ), which is asymptotically equivalent to O(N^2)O(N
​2
​​ ).
     */

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);

        for(int i=0;i< arr.length-2;i++) {
            if(i> 0 && arr[i] == arr[i-1])
                continue;
            findTriplets(arr, triplets, i+1, -arr[i]);
        }
        return triplets;
    }

    private static void findTriplets(int[] arr, List<List<Integer>> triplets, int left, int target) {

        int right = arr.length-1;
        while(left < right) {
            int currentSUm = arr[left] + arr[right];
            if (currentSUm == target) {
                triplets.add(Arrays.asList(arr[left], arr[right], -target));

                left++;
                right--;

                while(left < right && arr[left-1] == arr[left])
                    left++;

                while (left < right && arr[right] == arr[right+1])
                    right--;
            } else if(currentSUm > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
