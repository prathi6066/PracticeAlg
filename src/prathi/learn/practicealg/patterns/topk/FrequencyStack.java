package prathi.learn.practicealg.patterns.topk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class FrequencyStack {

    private  class Element {
         int frequencyCount;
         int number;
         int sequenctNumber;

        Element(int frequencyCount, int number, int sequenctNumber) {
            this.frequencyCount = frequencyCount;
            this.number = number;
            this.sequenctNumber = sequenctNumber;
        }
    }

    private class ElementComparator implements Comparator<Element> {

        @Override
        public int compare(Element o1, Element o2) {
            if(o1.frequencyCount != o2.frequencyCount)
            return o2.frequencyCount- o1.frequencyCount;
            else
                return o2.sequenctNumber-o1.sequenctNumber;
        }
    }
    int sequence = 0;
    PriorityQueue<Element> queue = new PriorityQueue<>(new ElementComparator());
    HashMap<Integer, Integer> map = new HashMap<>();


    public void push(int num) {
        // TODO: Write your code here
        map.put(num, map.getOrDefault(num, 0) +1);
        queue.add(new Element(map.get(num), num, sequence++));

    }

    public int pop() {
        // TODO: Write your code here
        if (!queue.isEmpty()) {
            Element temp = queue.poll();
            if(map.get(temp.number) > 1) {
                map.put(temp.number, map.get(temp.number)-1);
            } else {
                map.remove(temp.number);
            }
            return temp.number;
        }
        return -1;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
