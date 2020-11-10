package prathi.learn.practicealg.strings;

public class BalancedStringsCount {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        char[] str = s.toCharArray();
        int resultCount = 0;
        int count = 0;
        for (char c: str) {
            if (c == 'R' || c == 'L') {
                if (c == 'R') {
                    count++;
                } else {
                    count--;
                }

                if (count == 0)
                    resultCount++;
            }
        }

        return resultCount;
    }
}
