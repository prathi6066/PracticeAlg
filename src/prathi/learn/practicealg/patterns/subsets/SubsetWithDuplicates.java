package prathi.learn.practicealg.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetWithDuplicates {
    /*

    Given a set of numbers that might contain duplicates, find all of its distinct subsets.

    Input: [1, 3, 3]
    Output: [], [1], [3], [1,3], [3,3], [1,3,3]

    Time: O(N∗2^N)
     */

    private static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // TODO: Write your code here

        //sort the numbers
        Arrays.sort(nums);

        subsets.add(new ArrayList<>());

        int start = 0, end = 0;
        for(int i=0;i < nums.length;i++) {
            //if numbers are same skip the subsets other than the recent subsets that was added for the last number
            if(i > 0 && nums[i] == nums[i-1]) {
                start = end +1;
            }
            end = subsets.size() - 1;

            for(int j= start;j<= end;j++) {
               List<Integer> temp = new ArrayList<>(subsets.get(j));
               temp.add(nums[i]);
               subsets.add(temp);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
