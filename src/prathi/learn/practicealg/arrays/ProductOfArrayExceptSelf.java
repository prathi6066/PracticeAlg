package prathi.learn.practicealg.arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] res = productExceptSelf(new int[] {1, 2, 3, 4});
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int productSum = 1;
        int zeroCount = 0;
        int[] result = new int[nums.length];

        for (int num: nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                productSum = productSum * num;
            }
        }

        for (int i =0;i <nums.length; i++) {
            if (nums[i] == 0)
                result[i] = (zeroCount == 1) ? productSum: 0;
            else {
                result[i] = (zeroCount == 0) ? productSum / nums[i] : 0;
            }
        }

        return result;
    }
}
