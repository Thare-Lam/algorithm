package nowcoder.test2016._696d1c350cf1492c9b22ad232614086f;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 32;
        while (scanner.hasNextInt()) {
            int p = scanner.nextInt();
            int n = scanner.nextInt();
            int[] bitmap = new int[p / size + (p % size == 0 ? 0 : 1)];
            int i = 0, mod, index, b;
            boolean flag = true;
            int result = -1;
            for (; i < n; ++i) {
                mod = scanner.nextInt() % p;
                if (flag) {
                    index = mod / size;
                    b = 1 << (mod % size);
                    if ((bitmap[index] & b) != 0) {
                        result = i + 1;
                        flag = false;
                    } else {
                        bitmap[index] |= b;
                    }
                }
            }
            System.out.println(result);
        }
    }

}
