package lintcode.expression_evaluation;

import java.util.*;

public class Solution {

    /*
     * @param expression: a list of strings
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> optStack = new Stack<>();
        Set<String> optSet = getOptSet();
        for (String s : expression) {
            if (optSet.contains(s)) {
                if (!optStack.isEmpty() && compare(optStack.peek(), s) < 0) {
                    doCal(numStack, optStack);
                }
                if (s.equals(")")) {
                    optStack.pop();
                } else {
                    optStack.push(s);
                }
            } else {
                numStack.push(Integer.valueOf(s));
                if (!optStack.isEmpty() && getOptLevel(optStack.peek()) == 1) {
                    doCal(numStack, optStack);
                }
            }
        }
        while (optStack.size() > 0) {
            doCal(numStack, optStack);
        }
        if (numStack.size() > 0) {
            return numStack.pop();
        }
        return 0;
    }

    private void doCal(Stack<Integer> numStack, Stack<String> optStack) {
        if (optStack.peek().equals("(")) {
            return;
        }
        int b = numStack.pop();
        int a = numStack.pop();
        numStack.push(cal(a, b, optStack.pop()));
    }

    private int cal(int a, int b, String opt) {
        switch (opt) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }

    private int compare(String o1, String o2) {
        if (o2.equals(")") || (getOptLevel(o1) != 0 && getOptLevel(o2) == -1)) {
            return -1;
        }
        return 1;
    }

    private int getOptLevel(String opt) {
        switch (opt) {
            case "+":
            case "-":
                return -1;
            case "*":
            case "/":
                return 1;
            default:
                return 0;
        }
    }

    private Set<String> getOptSet() {
        Set<String> optSet = new HashSet<>();
        String opts = "+-*/()";
        for (int i = opts.length() - 1; i >= 0; --i) {
            optSet.add(String.valueOf(opts.charAt(i)));
        }
        return optSet;
    }

}
