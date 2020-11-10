package prathi.learn.practicealg.dp;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacciWithRecursion(5));
        System.out.println(fibonacciWithCache(5));
        System.out.println(fibonacciOptimized(5));
    }


    private static int fibonacciWithRecursion(int n) {
        if (n == 0 || n == 1)
            return n;
        return fibonacciWithRecursion(n-1) + fibonacciWithRecursion(n-2);
    }

    //bottom down approach
    private static int fibonacciWithCache(int n) {
        if (n == 0)
            return n;
        int[] caches = new int[n+1];

        caches[0] = 0;
        caches[1] = 1;
        for (int i = 2; i <= n; i++) {
            caches[i] = caches[i-1] + caches[i-2];
        }

        return caches[n];
    }

    private static int fibonacciOptimized(int n) {
        if (n == 0)
            return n;

        int n1= 0, n2 = 1;
        for (int i= 2; i <= n; i++) {
            int n0 = n1 + n2;
            n1 = n2;
            n2 = n0;
        }

        return n2;
    }

}

