package prathi.learn.practicealg.arrays;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {

        if (n ==1)
            return "1";

        String result = "";
        String current = "1";

        for (int i=2; i<=n;i++) {
            int count = 0;

            char prev = ' ';
            int j = current.length();
            if (j >= 1) {
                prev = current.charAt(j - 1);
                j--;
            }
            while (j >= 0) {
                if (current.charAt(j) == prev) {
                    count++;
                } else {
                    result = "" + result + count + prev;
                    count = 1;
                }
                prev = current.charAt(j);
                j--;
            }

            result = "" + count + prev + result;
            current = result;
            result = "";

        }

        return current;
    }

}
