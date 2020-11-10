package prathi.learn.practicealg.strings;

public class ConvertToLowerCase {

    public static void main(String[] args) {

        System.out.println(toLowerCase("HRR4 4RR$"));
    }

    public static String toLowerCase(String str) {
        StringBuilder result= new StringBuilder();
        char[] charStr = str.toCharArray();
        for (char c: charStr) {
            result.append(Character.toLowerCase(c));
        }

        return result.toString();
    }
}
