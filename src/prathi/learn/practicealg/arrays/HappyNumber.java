package prathi.learn.practicealg.arrays;

import java.util.HashSet;

public class HappyNumber {

    static int count = 0;
    public static void main(String[] args) {
        System.out.println(isHappy2(20));
    }

    public static boolean isHappy2(int n) {
        HashSet<Integer> set = new HashSet<>();
        int num = n;
        while (num != 1 && !set.contains(num)) {
            set.add(num);
            num = getSquare(num);
        }

        return (num == 1);

    }

    private static int getSquare(int num) {
        int val = num;
        int result = 0;
        while (val > 0) {
            int x = val % 10;
            val = val / 10;
            result = result + (x * x);
        }
        return result;
    }

    public static boolean isHappy(int n) {
        int currentSum = n;
        while (currentSum / 10 > 0 || (currentSum > 2 && count < 10)) {
            count++;
            currentSum = getSquareSum(currentSum, 0);
        }

        return (getSquareSum(currentSum, 0) == 1);

    }

    private static int getSquareSum(int n, int sum) {

        if (n == 0)
            return sum;

        if (n /10  < 0)
            return sum + (n * n);

        return getSquareSum(n/10, sum + ((n % 10) * (n % 10)));
    }
}
