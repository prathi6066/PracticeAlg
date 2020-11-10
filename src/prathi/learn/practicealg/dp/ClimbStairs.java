package prathi.learn.practicealg.dp;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStair(3));
    }

    private static int climbStair(int n) {

        if (n <= 2) {
            return n;
        } else {

            int n1 = 1;
            int n2 = 2;

            for(int i =3; i<=n;i++) {
                int n0 = n2 + n1;
                n1 = n2;
                n2 = n0;
            }

            return n2;

        }
    }
}
