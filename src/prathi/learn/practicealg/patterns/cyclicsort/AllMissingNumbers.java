package prathi.learn.practicealg.patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {

    /*
    We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

    Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.

Time: The time complexity of the above algorithm is O(n).
     */

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        // TODO: Write your code here
        int i=0;
        while(i< nums.length) {
            if (nums[i] != nums[nums[i]-1]) {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            } else {
                i++;
            }
        }

        for(int j=0;j<nums.length;j++) {
            if(nums[j] != j+1) {
                missingNumbers.add(j+1);
            }
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
