package prathi.learn.practicealg;

public class TestClass {
    private static int[] coins = new int[]{10, 6, 1};

    public static void main(String[] args) {

       // System.out.println(makeChange(12));
        int[] arr= {91,41,78,86,8};
        System.out.println(smallestdivisor(arr, 114));
    }



    public static int findDivisorSum(int[] arr, int diivisor) {
        int sum = 0;
        for (int a: arr) {
            int ceil = (int)Math.ceil(a/(float)diivisor);
            sum+=ceil;
        }
        return sum;
    }

    public static int smallestdivisor(int[] nums, int threshold) {
        int left = 1;
        int right = findMax(nums);
        int m = 0;

        while (left <= right) {
            int divisor = findDivisorSum(nums, m=(left+right)/2);
            if (divisor > threshold) {
                left = m+1;
            }  else {
                right = m-1;
            }
        }

        return left;
    }

    private static int findMax(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum = Math.max(sum, n);
        }
        return sum;
    }

    // Overloaded recursive function
    public static int makeChange(int c) {
        int[] cache = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            int minCoins = Integer.MAX_VALUE;

            // Try removing each coin from the total
            // and see which requires the fewest
            // extra coins
            for (int coin : coins) {
                if (i - coin >= 0) {
                    int currCoins = cache[i-coin] + 1;
                    if (currCoins < minCoins) {
                        minCoins = currCoins;
                    }
                }
            }
            cache[i] = minCoins;
        }

        return cache[c];
    }
}
