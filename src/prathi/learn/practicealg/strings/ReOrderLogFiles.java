package prathi.learn.practicealg.strings;

import java.util.Arrays;
import java.util.Comparator;

public class ReOrderLogFiles {

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        Arrays.sort(logs, new SortLexographically());

        for (String log: logs) {
            System.out.println(log);
        }

    }

    private static class SortLexographically implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] first = o1.split(" ");
            String[] second = o2.split(" ");
            if (first.length > 2 && second.length > 2) {
                if(Character.isLetter(first[1].charAt(0)) && Character.isLetter(second[1].charAt(0))){
                    if (first[1].compareTo(second[1]) != 0)
                        return first[1].compareTo(second[1]);
                    return first[0].compareTo(second[0]);
                } else {
                    if (Character.isDigit(first[1].charAt(0))) {
                        return (Character.isDigit(second[1].charAt(0))) ? 0: 1;
                    }
                    return -1;
                }
            }

            return -1;
        }
    }
}
