package prathi.learn.practicealg.patterns.topk;

import java.util.*;

class RearrangeStringKDistanceApart {

    public static String reorganizeString(String str, int k) {
        // TODO: Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());
        map.entrySet().forEach(it->{
            priorityQueue.add(it);
        });

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while(!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> current = priorityQueue.poll();
            stringBuilder.append(current.getKey());
            current.setValue(current.getValue()-1);
            queue.add(current);
            if(queue.size() ==  k) {
                current = queue.poll();
                if (current.getValue() > 0)
                    priorityQueue.add(current);
            }
        }
        return stringBuilder.length() == str.length() ? stringBuilder.toString() : "";
    }

    public static void main(String[] args) {
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aab", 2));
        System.out.println("Reorganized string: " +
                RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
    }
}
