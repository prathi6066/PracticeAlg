package prathi.learn.practicealg.general;

public class MinStack {

    int current_size = 0;
    int min_size = 5;
    int mini_value = Integer.MAX_VALUE;

    int[] myMinStack;

    /** initialize your data structure here. */
    public MinStack() {
        myMinStack = new int[min_size];

    }

    public void push(int x) {
        if (x < mini_value)
            mini_value = x;

        if (current_size >= min_size) {
            min_size = min_size * 2;
            int[] newMinstack = new int[min_size];
            System.arraycopy(myMinStack, 0, newMinstack, 0, min_size/2);
            myMinStack = newMinstack;
        }

        if (current_size < min_size) {
            myMinStack[current_size] = x;
            current_size++;
        }
    }

    public void pop() {
        if (current_size > 0) {
            int value = myMinStack[current_size-1];
            myMinStack[current_size-1] = 0;
            current_size --;
            if (value == mini_value) {
                mini_value = Integer.MAX_VALUE;
                updateMinValue();
            }
        }
    }

    public int top() {
        if (current_size > 0) {
            return  myMinStack[current_size-1];
        }

        return -1;
    }

    private void updateMinValue() {
        int currentVal = Integer.MAX_VALUE;
        for (int i=0;i<current_size;i++) {
            if (myMinStack[i] < currentVal)
                currentVal = myMinStack[i];
        }
        mini_value = currentVal;
    }

    public int getMin() {
        return mini_value;

    }
}

