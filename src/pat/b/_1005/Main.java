package pat.b._1005;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        Set<Integer> set1;
        Set<Integer> set2;
        Set<Integer> set3;
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            set1 = new TreeSet<Integer>();
            set2 = new HashSet<Integer>();
            set3 = new TreeSet<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            while (n > 0) {
                k = scanner.nextInt();
                if (set2.contains(k)) {
                    --n;
                    continue;
                }
                set1.add(k);
                while (k > 1) {
                    if ((k & 1) == 0) {
                        k >>= 1;
                    } else {
                        k = ((k << 1) + k + 1) >> 1;
                    }
                    if (set2.contains(k)) {
                        break;
                    } else {
                        set2.add(k);
                    }
                }
                --n;
            }
            for (int i : set1) {
                if (!set2.contains(i)) {
                    set3.add(i);
                }
            }
            Iterator<Integer> iterator = set3.iterator();
            if (iterator.hasNext()) {
                System.out.print(iterator.next());
            }
            while (iterator.hasNext()) {
                System.out.print(" " + iterator.next());
            }
            System.out.println();
        }
    }
}
