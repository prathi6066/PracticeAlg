package prathi.learn.practicealg.strings;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {

    public static void main(String[] args) {
        List<String> res = printVertically("How arefff youd");
        for (String s: res) {
            System.out.println(s);
        }
    }


    private static List<String> printVertically(String s) {
        String[] words = s.split(" ");
        List<String> result = new ArrayList<>();
        int maxStrLength = 0;

        for (String word: words) {
            if (word.length() > maxStrLength)
                maxStrLength = word.length();
        }

        for (int i=0;i<words.length;i++) {
            for (int j=0;j<maxStrLength;j++) {
                if (words[i].length() > j) {

                    if (result.size() > j) {
                        result.set(j, result.get(j) + words[i].charAt(j));
                    } else {
                        result.add(j, words[i].charAt(j) + "");
                    }
                } else {
                    if (result.size() > j) {
                        result.set(j, result.get(j) + " ");
                    } else {
                        result.add(j, " ");
                    }
                }
            }
        }
        return removeTrailingSpaces(result);
    }

    private static List<String> removeTrailingSpaces(List<String> inputs) {
        List<String> result = new ArrayList<>();

        String regex = "\\s+$";
        for (String word: inputs) {
            result.add(word.replaceAll(regex, ""));
        }

        return result;
    }
}
