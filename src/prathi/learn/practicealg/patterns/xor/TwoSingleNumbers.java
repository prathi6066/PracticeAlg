package prathi.learn.practicealg.patterns.xor;

public class TwoSingleNumbers {
    /*
    In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
    Find the two numbers that appear only once.

    Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
Output: [4, 6]
     */

    public static int[] findSingleNumbers(int[] nums) {

        int setbit = 0;
        for (int num : nums) {
            setbit = setbit ^ num;
        }

        //1 will be set for bits that are different between the two numbers
        //find the last bit(right most bit) which is 1;

        int lastSetBit = 1;
        while ((lastSetBit & setbit) == 0) {
            lastSetBit = lastSetBit << 1;
        }
        //iterate through the array and split the number with this bit set to 1 and 0. Now n1 will be in left and num2 will be right
        int x1 = 0, x2 = 0;
        for (int num: nums) {
            if ((num & lastSetBit) == 0) {
                x1 = x1 ^ num;
            } else {
                x2 = x2 ^ num;
            }
        }

        return new int[] { x1, x2 };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }
}
