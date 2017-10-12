package hackerrank.reduced_string;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static String super_reduced_string(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "Empty String";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }

}
