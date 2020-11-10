package prathi.learn.practicealg.strings;

public class StringToInteger {

    public static void main(String[] args) {
        //System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoiOptmized("2147483648"));

    }

    private static  int myAtoiOptmized(String str) {

        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        int res = 0;
        int sign = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ' && res == 0 && sign == 0) {
                i++;
                continue;
            }

            if ((str.charAt(i) == '-' || str.charAt(i) == '+') && res == 0 && sign == 0) {
                sign = (str.charAt(i) == '-') ? -1 : 1;
            } else if (Character.isDigit(str.charAt(i))) {
                if (res > Integer.MAX_VALUE / 10 ||
                        (res == Integer.MAX_VALUE / 10 &&
                                str.charAt(i) - '0' > 7))
                {
                    if (sign == 1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                res = 10 * res + (str.charAt(i) - '0');
            } else if (res == 0) {
                return 0;
            } else {
                return (sign == 0) ? res : res * sign;
            }
            i++;
        }

        return (sign == 0) ? res : res * sign;
    }

    private static  int myAtoi(String str) {

        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char sign = ' ';
        while (i < str.length()) {
            if (str.charAt(i) == ' ' && stringBuilder.length() == 0 && sign == ' ') {
                i++;
                continue;
            }

            if ((str.charAt(i) == '-' || str.charAt(i) == '+') && stringBuilder.length() == 0 && sign == ' ') {
                sign = str.charAt(i);
            } else if (Character.isDigit(str.charAt(i))) {
                stringBuilder.append(str.charAt(i));
            } else if (stringBuilder.length() == 0) {
                return 0;
            } else {
                return findAtoi(stringBuilder, sign);
            }
            i++;
        }

        return findAtoi(stringBuilder, sign);
    }

    private static int findAtoi(StringBuilder stringBuilder, char sign) {
        if (stringBuilder.length() == 0)
            return 0;
        try {
            if (Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE)
                return (sign == '-')? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } catch (Exception e) {
            return (sign == '-')? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        String res;
        if (sign == ' ')
            res = stringBuilder.toString();
        else
            res = sign + stringBuilder.toString();
        return Integer.parseInt(res);
    }
}
