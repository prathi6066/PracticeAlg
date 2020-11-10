package prathi.learn.practicealg.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        for (List<String> result: res) {
            for (String val: result) {
                System.out.print(val + " ");
            }
            System.out.println(" ");
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String keyVal = new String(tmp);
            if (map.containsKey(keyVal)) {
                List<String> value= map.get(keyVal);
                value.add(str);
                map.put(keyVal, value);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(str);
                map.put(keyVal, stringList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        map.forEach((k,v) -> {
            result.add(v);
        });


        return result;
    }
}
