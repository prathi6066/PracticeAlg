package prathi.learn.practicealg.patterns.subsets;

import java.util.*;

class Subsets {
    /*
    Given a set with distinct elements, find all of its distinct subsets.

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

Time: we will have a total of O(2^N) subsets. - O( N * 2^N)

     */

    private static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // TODO: Write your code here

        subsets.add(new ArrayList<Integer>());
        for (int num: nums) {
            int listSize = subsets.size();
            for(int i=0;i<listSize;i++) {
                List<Integer> tempList = new ArrayList<>(subsets.get(i));
                tempList.add(num);
                subsets.add(tempList);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
