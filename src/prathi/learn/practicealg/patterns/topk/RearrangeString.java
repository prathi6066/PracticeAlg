package prathi.learn.practicealg.patterns.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class RearrangeString {

    public static String rearrangeString(String str) {
        // TODO: Write your code here
        Map<Character, Integer> map = new HashMap<>();
        for(char c: str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());

        map.entrySet().forEach(it -> {
            queue.add(it);
        });

        StringBuilder stringBuilder = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        while(!queue.isEmpty()) {
            Map.Entry<Character, Integer> tmp = queue.poll();
            stringBuilder.append(tmp.getKey());
            if(prev != null && prev.getValue() > 1) {
                prev.setValue(prev.getValue()-1);
                queue.add(prev);
            }
            prev = tmp;
        }
        return (prev != null && prev.getValue() > 1) ? "" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }
}
