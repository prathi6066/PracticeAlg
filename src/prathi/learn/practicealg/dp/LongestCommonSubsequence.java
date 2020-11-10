package prathi.learn.practicealg.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("aggtab", "gxtxayb"));
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int[][] lcs = new int[text1.length() +1 ][text2.length() + 1];

        for (int i=0 ; i< text1.length(); i++) {
            lcs[i][0] = 0;
        }

        for (int i=0 ; i< text2.length(); i++) {
            lcs[0][1] = 0;
        }

        for (int i=1; i<= text1.length(); i++) {
            for (int j=1; j<= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }

        return lcs[text1.length()][text2.length()];
    }
}
