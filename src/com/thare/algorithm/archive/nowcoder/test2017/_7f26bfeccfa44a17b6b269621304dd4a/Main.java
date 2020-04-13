package com.thare.algorithm.archive.nowcoder.test2017._7f26bfeccfa44a17b6b269621304dd4a;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] str = scanner.next().toCharArray();
            int k = scanner.nextInt();
            process(str, k);
        }
    }

    private static void process(char[] str, int k) {
        int i = 1;
        Stack<Character> stack = new Stack<>();
        stack.push(str[0]);
        while (k > 0 && i < str.length) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < str[i]) {
                stack.pop();
                --k;
            }
            stack.push(str[i]);
            ++i;
        }
        while (k-- > 0) {
            stack.pop();
        }
        printStack(stack);
        printCharArr(str, i);
        System.out.println();
    }

    private static void printStack(Stack<Character> stack) {
        for (char c : stack) {
            System.out.print(c);
        }
    }

    private static void printCharArr(char[] str, int start) {
        while (start < str.length) {
            System.out.print(str[start++]);
        }
    }
}
