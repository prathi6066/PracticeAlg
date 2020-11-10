package prathi.learn.practicealg.strings;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 0)
            return "";

        if (numRows == 1)
            return s;

        String[] arr = new String[numRows];
        StringBuilder res = new StringBuilder();

        boolean directionDown = true;
        int currIndex = 0;

        for (int i = 0; i < s.length(); i++) {
             String curr = arr[currIndex];
             arr[currIndex] = (curr != null) ? arr[currIndex] + s.charAt(i) : s.charAt(i) + "";

             if (currIndex == numRows - 1)
                 directionDown = false;
             else if (currIndex == 0)
                 directionDown = true;

             if (directionDown)
                 currIndex++;
             else
                 currIndex--;

        }

        for (String str: arr) {
            if (str != null &&  str != "null")
                res.append(str);
        }


        return res.toString();
    }
}
