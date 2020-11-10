package prathi.learn.practicealg.strings;

import java.util.HashMap;
import java.util.Map;

public class PerformStringShifts {

    public static void main(String[] args) {
        int[][] shift = {
                {1, 4},
                {0,7},
                {0,8},
                {0,7},
                {0,6},
                {1,3},
                {0,1},
                {1, 7},
                {0,5},
                {0,6}
        };

        String s = "xqgwkiqpif";

        System.out.println(stringShift(s, shift));
    }

    public static String stringShift(String s, int[][] shift) {
        int leftShiftCount = 0;
        int rightShiftCount = 0;

        for (int i = 0;i<shift.length;i++) {
            if (shift[i][0] == 0) {
                leftShiftCount +=shift[i][1];
            } else {
                rightShiftCount += shift[i][1];
            }
        }

        if (rightShiftCount == leftShiftCount)
            return s;

        if (rightShiftCount >= leftShiftCount) {
            rightShiftCount = rightShiftCount - leftShiftCount;
            leftShiftCount = 0;
        } else {
            leftShiftCount = leftShiftCount - rightShiftCount;
            rightShiftCount = 0;
        }

        if (rightShiftCount > 0) {
            char[] str = s.toCharArray();
            rotate(str, rightShiftCount);
            return new String(str);

        } else {
            if (leftShiftCount > s.length())
                leftShiftCount = leftShiftCount % s.length();
            String result = s.substring(0, leftShiftCount);
            String result2 = s.substring(leftShiftCount);
            return result2+result;
        }
    }

    private static void rotate(char[] nums, int k) {
        if (k > nums.length)
            k = k % nums.length;

        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(i, nums[i]);

        for (int i = 0; i < nums.length; i++)
        {
            int newPos = i + k;
            if (newPos >= nums.length)
                newPos = newPos - nums.length;
            nums[newPos] = map.get(i);
        }
    }
}
