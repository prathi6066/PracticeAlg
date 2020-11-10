package prathi.learn.practicealg.strings;

public class RemoveSpacesInAString {

    public static void main(String[] args) {
        System.out.println(removeSpaces("  Hi there, how  are you   doing? "));
    }

    public static String removeSpaces(String str) {
        char[] ch = str.toCharArray();
        int start = -1;
        for (int end = 0; end < str.length(); end++) {
            if (str.charAt(end) == ' ' && start == -1) {
                start = end;
            } else {
                if (start != end && start != -1) {
                    if (ch[end] != ' ') {
                        char temp = ch[start];
                        ch[start] = ch[end];
                        ch[end] = temp;
                        start++;
                    }
                }
            }
        }

        return String.valueOf(ch);
    }
}
