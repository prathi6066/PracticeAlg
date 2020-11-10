package prathi.learn.practicealg.patterns.topk;

import java.util.Comparator;
import java.util.PriorityQueue;

class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        // TODO: Write your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int ropeLength: ropeLengths) {
            queue.add(ropeLength);
        }
        int res = 0;

        while(!queue.isEmpty()) {
            int first = queue.poll();
            if (!queue.isEmpty()) {
                int sec = queue.poll();
                res += first + sec;
                queue.add(first + sec);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}