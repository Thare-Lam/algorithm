package nowcoder.Test2017._18ecd0ecf5ef4fe9ba3f17f8d00d2d66;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            map.put(1, 1);
            map.put(2, 1);
            int index = 0;
            while (fb(map, index++) < n);
            if (map.get(index - 1) == n) {
                System.out.println(0);
            } else {
                System.out.println(Math.min(map.get(index - 1) - n, n - map.get(index - 2)));
            }
        }
    }

    private static int fb(Map<Integer, Integer> map, int x) {
        if (map.containsKey(x)) {
            return map.get(x);
        }
        int res = fb(map, x - 1) + fb(map, x - 2);
        map.put(x, res);
        return res;
    }

}
