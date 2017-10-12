package nowcoder.test2017._571cfbe764824f03b5c0bfd2eb0a8ddf;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int p = scanner.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            Map<String,Integer> map = new HashMap<>();
            Stack<String> stack = new Stack<>();
            Set<String> set = new HashSet<>();
            Object[] res = recursion(map, stack, set, maze, n, m, p,0, 0);
            if (res != null) {
                printStack((Stack<String>)res[1], true);
                System.out.println();
            } else {
                System.out.println("Can not escape!");
            }
        }
    }

    private static Object[] recursion(Map<String, Integer> map, Stack<String> stack, Set<String> set, int[][] maze, int n, int m, int p, int x, int y) {
        String str = genStr(x, y);
        if (p < 0 || set.contains(str)) {
            return null;
        }
        if (map.containsKey(str) && map.get(str) >= p) {
            return null;
        }
        stack.push(str);
        set.add(str);
        if (x == 0 && y == m - 1) {
            return new Object[]{p, stack};
        }
        Object[] temp = new Object[4];
        if (x < n - 1 && maze[x + 1][y] != 0) {
            temp[0] = recursion(map, (Stack<String>)stack.clone(), deepCopy(set), maze, n, m,p , x + 1, y);
        }
        if (y > 0 && maze[x][y - 1] != 0) {
            temp[1] = recursion(map, (Stack<String>)stack.clone(), deepCopy(set), maze, n, m,p - 1, x, y - 1);
        }
        if (y < m - 1 && maze[x][y + 1] != 0) {
            temp[2] = recursion(map, (Stack<String>)stack.clone(), deepCopy(set), maze, n, m,p - 1, x, y + 1);
        }
        if (x > 0 && maze[x - 1][y] != 0) {
            temp[3] = recursion(map, (Stack<String>)stack.clone(), deepCopy(set), maze, n, m,p - 3, x - 1, y);
        }
        int maxP = -1;
        int index = -1;
        for (int i = 0; i < 4; ++i) {
            if (temp[i] != null) {
                Object[] t = (Object[]) temp[i];
                if ((int) t[0] > maxP) {
                    maxP = (int) t[0];
                    index = i;
                }
            }
        }
        if (index == -1) {
            stack.pop();
            set.remove(str);
            map.put(str, p);
            return null;
        } else {
            return (Object[])temp[index];
        }
    }

    private static String genStr(int x, int y) {
        return String.format("[%d,%d]", x, y);
    }

    private static void printStack(Stack<String> stack, boolean lastFlag) {
        String str = stack.pop();
        if (!stack.isEmpty()) {
            printStack(stack, false);
        }
        if (lastFlag) {
            System.out.print(str);
        } else {
            System.out.print(str + ",");
        }
    }

    private static HashSet<String> deepCopy(Set<String> set) {
        HashSet<String> copy = new HashSet<>(set.size());
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            copy.add(iterator.next());
        }
        return copy;
    }
}
