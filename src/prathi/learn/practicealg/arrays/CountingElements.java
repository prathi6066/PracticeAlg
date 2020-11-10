package prathi.learn.practicealg.arrays;

import java.util.HashSet;

public class CountingElements {

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1,1, 2, 2}));
    }

    public static int countElements(int[] arr) {
        int count = 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num: arr) {
            set.add(num);
        }

        for (int num: arr) {
            if (set.contains(num+1))
                count++;
        }

        return count;
    }
}
