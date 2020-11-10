package prathi.learn.practicealg.arrays;

public class PaliindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        int temp = x;
        int res = 0;

        while (temp > 0) {
            int val = temp % 10;
            temp = temp/10;
            res = res * 10 + val;

        }
        return res == x;

    }
}
