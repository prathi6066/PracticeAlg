package prathi.learn.practicealg.strings;

public class ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }

    public static boolean checkValidString(String s) {
        int i = 0;
        int j = s.length()-1;
        int left = 0;
        int right = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '*' || s.charAt(i) == '(')
                left++;
            else
                left--;

            if (s.charAt(j) == '*' || s.charAt(j) ==')')
                right++;
            else
                right--;
            i++;
            j--;
        }

        if (right < 0 || left < 0) {
            return false;
        }

        return true;

    }
}
