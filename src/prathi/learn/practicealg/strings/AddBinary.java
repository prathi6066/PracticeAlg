package prathi.learn.practicealg.strings;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1"));
    }

    public static String addBinary(String a, String b) {

        if (a.isEmpty())
            return b;

        if (b.isEmpty())
            return a;

        int len1 = a.length()-1;
        int len2 = b.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while (len1 >=0 || len2 >=0) {
            int aVal = 0;
            int bVal = 0;

            if (len1 >= 0)
                aVal = Integer.parseInt(String.valueOf(a.charAt(len1)));

            if (len2 >=0)
                bVal = Integer.parseInt(String.valueOf(b.charAt(len2)));

            int sum = carry+ aVal+ bVal;
            if (sum == 3) {
                stringBuilder.append("1");
                carry = 1;
            } else if(sum == 2) {
                stringBuilder.append("0");
                carry = 1;
            } else {
                stringBuilder.append(sum);
                carry = 0;
            }

            len1--;
            len2--;
        }

        if (carry == 1)
            stringBuilder.append("1");

        return stringBuilder.reverse().toString();
    }
}
