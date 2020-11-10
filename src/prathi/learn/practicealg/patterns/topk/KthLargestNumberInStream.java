package prathi.learn.practicealg.patterns.topk;

import java.util.*;

class KthLargestNumberInStream {

    private int k;
    PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2)->n1-n2);
    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        // TODO: Write your code here
        for (int num: nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int num) {
        // TODO: Write your code here
        queue.add(num);
        if (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
