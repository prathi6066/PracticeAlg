package prathi.learn.practicealg.strings;

public class ReverseOnlyLetters {

    public static void main(String[] args) {

        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));

    }

    private static String reverseOnlyLetters(String S) {
        char[] ch = S.toCharArray();

        if (S.length() ==0)
            return S;

        int start = 0;
        int end = S.length() - 1;

        while (start < end) {
            if (!Character.isAlphabetic(S.charAt(start))) {
                start++;
            }

            if (!Character.isAlphabetic(S.charAt(end))) {
                end--;
            }

            if (Character.isAlphabetic(S.charAt(start)) && Character.isAlphabetic(S.charAt(end))) {
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }

        return String.valueOf(ch);

    }
}
