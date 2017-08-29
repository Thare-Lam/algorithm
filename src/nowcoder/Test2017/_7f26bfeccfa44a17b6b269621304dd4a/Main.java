package nowcoder.Test2017._7f26bfeccfa44a17b6b269621304dd4a;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] str = scanner.next().toCharArray();
            int k = scanner.nextInt();
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
            while (k > 0) {
                stack.pop();
                --k;
            }
            for (char c : stack) {
                System.out.print(c);
            }
            while (i < str.length) {
                System.out.print(str[i++]);
            }
            System.out.println();
        }
    }
}
