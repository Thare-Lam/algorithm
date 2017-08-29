package lintcode.min_stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> stackMin;

    public MinStack() {
        stack = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (!stackMin.isEmpty()) {
            int min = stackMin.peek();
            stackMin.push(min > number ? number : min);
        } else {
            stackMin.push(number);
        }
    }

    public int pop() {
        stackMin.pop();
        return stack.pop();
    }

    public int min() {
        return stackMin.peek();
    }
}
