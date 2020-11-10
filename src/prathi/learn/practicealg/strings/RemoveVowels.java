package prathi.learn.practicealg.strings;

public class RemoveVowels {

    public static void main(String[] args) {
        System.out.println(removeVowelsFromString("prathibha"));
        System.out.println(removeVowelsFromStr("prathibha"));
    }

    private static String removeVowelsFromString(String vowel) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] value = vowel.toCharArray();
        for (char c : value) {
            if (c != 'a' && c != 'e' && c!='i' && c != 'o' && c!='u') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private static String removeVowelsFromStr(String vowel) {
        return vowel.replaceAll("[AEIOUaeiou]","");
    }

}
