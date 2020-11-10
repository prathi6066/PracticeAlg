package prathi.learn.practicealg.general;

public class TestClass {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(10);
        minStack.push(11);
        minStack.push(12);
        minStack.push(13);
        minStack.push(14);
        minStack.push(8);
        minStack.push(2);

        minStack.pop();


        int param_3 = minStack.top();
        int param_4 = minStack.getMin();
    }
}
