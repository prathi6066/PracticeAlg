package prathi.learn.practicealg.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostCommonWord {

    public static void main(String[] args) {
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        List<String> bList = Arrays.asList(banned);
        HashMap<String, Integer> map = new HashMap<>();
        String result = "";
        int maxCount = Integer.MIN_VALUE;

        String[] stringList = paragraph.split("[ !?',;.]+");
        for (String clearS: stringList) {
            if (!bList.contains(clearS.toLowerCase())) {
                if (map.containsKey(clearS.toLowerCase())) {
                    map.put(clearS.toLowerCase(), map.get(clearS.toLowerCase())+1);
                } else {
                    map.put(clearS.toLowerCase(), 1);
                }
            }
        }

        for (String k: map.keySet()) {
            if (map.get(k) != null && map.get(k) > maxCount) {
                result = k;
                maxCount = map.get(k);
            }
        }

        return result;
    }
}
