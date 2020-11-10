package prathi.learn.practicealg.patterns.twopointer;

public class ShortestWindowSort {

    /*
    Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

    Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted


Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted


From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
Find the maximum and minimum of this subarray.
Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.
     */

    public static int sort(int[] arr) {
        // TODO: Write your code here
        int left =0;
        int right = arr.length-1;

        while (left < arr.length-1 && arr[left] < arr[left+1]) {
            left++;
        }

        if(left == arr.length - 1) return 0;

        while(right > 0 && arr[right] > arr[right-1]) {
            right--;
        }

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = left; k <= right; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (left > 0 && arr[left - 1] > subarrayMin)
            left--;
        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (right < arr.length - 1 && arr[right + 1] < subarrayMax)
            right++;


        return (right-left + 1);
    }

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        //System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        //System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        //System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }
}
