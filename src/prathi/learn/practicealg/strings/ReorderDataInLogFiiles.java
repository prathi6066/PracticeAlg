package prathi.learn.practicealg.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class ReorderDataInLogFiiles {

    public static void main(String[] args) {
        String[] logs = reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"});

        for (String log: logs) {
            System.out.println(log);
        }

    }

    public static String[] reorderLogFiles(String[] logs) {
        String[] result = logs;
        Arrays.sort(result, new SortString());
        return result;
    }

    private static class  SortString implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] s1 = o1.split(Pattern.quote(" "));
            String[] s2 = o2.split(Pattern.quote(" "));

            if (Character.isLetter(s1[1].charAt(0)) &&  Character.isLetter(s2[1].charAt(0))) {
                if (s1[1].compareTo(s2[1]) == 0)
                    return (s1[2].compareTo(s2[2]) == 0) ? s1[0].compareTo(s2[0]) : s1[2].compareTo(s2[2]);
                else
                    return s1[1].compareTo(s2[1]);
            } else if (Character.isDigit(s1[1].charAt(0))) {
                return (Character.isDigit(s2[1].charAt(0)) ? 0 : 1);
            }
            return -1;
        }
    }
}
