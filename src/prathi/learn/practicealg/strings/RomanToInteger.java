package prathi.learn.practicealg.strings;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] input = s.toCharArray();
        int sum = 0;
        int prev = 0;

        for (int i = input.length-1; i>= 0; i--) {
            if (map.get(input[i]) < prev) {
                sum = sum - map.get(input[i]);
            } else {
                sum = sum + map.get(input[i]);
            }
            prev =  map.get(input[i]);
        }

        return sum;

    }
}
