package prathi.learn.practicealg.patterns.subsets;

import java.util.*;

class Permutations {

    /*
    Given a set of distinct numbers, find all of its permutations.

    Input: [1,3,5]
    Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
     */

    private static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutationList = new LinkedList<>();
        permutationList.add(new ArrayList<>());
        for (int num: nums) {

            int listSize = permutationList.size();

            for(int i=0;i<listSize;i++) {
                List<Integer> currentPermutation = permutationList.poll();
                int n = currentPermutation.size();
                for(int j=0;j<=n;j++) {
                    /*
                    inserting ‘5’ in different positions of [3,1] will give us the following permutations:

                    Inserting ‘5’ before ‘3’: [5,3,1]
                    Inserting ‘5’ between ‘3’ and ‘1’: [3,5,1]
                    Inserting ‘5’ after ‘1’: [3,1,5]
                     */

                    //add the current number at every position in the list.
                    List<Integer> newlist = new ArrayList<>(currentPermutation);
                    newlist.add(j, num);

                    if(newlist.size() == nums.length) {
                        result.add(newlist);
                    } else {
                        permutationList.add(newlist);
                    }
                }

            }
        }

        return result;
    }

    //recursive approach

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutation);
        } else {
            // create a new permutation by adding the current number at every position
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
