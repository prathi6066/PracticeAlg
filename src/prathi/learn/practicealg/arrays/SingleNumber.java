package prathi.learn.practicealg.arrays;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2,1, 2}));
    }

    public static int singleNumber(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum = sum ^ num;
        }


        return sum;

    }
}
