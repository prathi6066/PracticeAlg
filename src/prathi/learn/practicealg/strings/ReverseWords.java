package prathi.learn.practicealg.strings;

public class ReverseWords {

    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        return s;
    }

    public static void main(String[] args) {
        char[] s = getArray("Hello World!");
        System.out.println(s);
        reverseWords(s);
        System.out.println(s);
    }

    public static void reverseWords (char[] sentence) {

        if ( sentence == null || sentence.length == 0)
            return;

        //TODO: Write - Your - Code
        reverseString(sentence, 0, sentence.length-2);

        int left = 0;
        int right;


        while (true) {
            while (sentence[left] == ' ') left++;

            if( left >= sentence.length-1)
                break;

            right = left + 1;
            while(right < sentence.length-1 && sentence[right] != ' ') right++;

            reverseString(sentence, left, right-1);
            left = right;
        }
    }

    private static void reverseString(char[] str, int left, int right) {
        while (left <= right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}
