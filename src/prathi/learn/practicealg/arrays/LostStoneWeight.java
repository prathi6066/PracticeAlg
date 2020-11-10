package prathi.learn.practicealg.arrays;

import java.util.Arrays;

public class LostStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 2}));
    }

    public static  int lastStoneWeight(int[] stones) {

        int i = 0;
        int j = stones.length-1;

        while(i < j) {
            Arrays.sort(stones, i, j+1);
            int x = stones[j-1];
            int y = stones[j];
            if (x == y) {
                stones[j-1] = 0;
                stones[j] = 0;
                j = j -2;
            } else {
                stones[j-1] = y-x;
                stones[j] = 0;
                j= j-1;
            }
        }

        return stones[i];

    }

    private static void reverse(int[] array) {
        int i = 0;
        int j = array.length-1;

        while(i< j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
