package prathi.learn.practicealg.strings;

public class DecryptStringFromAToInt {

    public static void main(String[] args) {
        System.out.println(freqAlphabets("5"));
    }

    public static String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] output = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'};

        int n = s.length();
        for (int i=0; i<s.length();) {
            int hashIndex = i+2;
            int value;
            if (hashIndex < n && s.charAt(hashIndex) == '#') {
                value = Integer.parseInt(s.substring(i, hashIndex));
                i = i+3;
            } else {
                value = Character.getNumericValue(s.charAt(i));
                i++;
            }

            if (value <= 26 && value > 0) {
                stringBuilder.append(output[value]);
            }
        }

        return stringBuilder.toString();
    }

}
