package prathi.learn.practicealg.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        List<String> res = fizzBuzz(15);
        for (String s: res) {
            System.out.println(s);
        }
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "Frizz");
        map.put(5, "Buzz");

        for (int i=1; i<=n;i++) {
            String numStr = "";
            for (Integer key: map.keySet()) {
                if (i % key == 0) {
                    numStr += map.get(key);
                }
            }

            if(numStr.length() == 0) {
                numStr += Integer.toString(i);
            }

            res.add(numStr);
        }

        return res;

    }
}
