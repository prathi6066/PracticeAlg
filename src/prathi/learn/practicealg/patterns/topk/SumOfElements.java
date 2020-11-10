package prathi.learn.practicealg.patterns.topk;

import java.util.Comparator;
import java.util.PriorityQueue;

class SumOfElements {

    public static int findSumOfElements(int[] nums, int k1, int k2) {
        // TODO: Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int num: nums) {
            queue.add(num);
        }


        int tmp = 1;
        while(!queue.isEmpty() && tmp<=k1) {
            queue.poll();
            tmp++;
        }
        int sum = 0;
        for(int i=tmp;i<k2;i++) {
            if(!queue.isEmpty())
                sum+=queue.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}

