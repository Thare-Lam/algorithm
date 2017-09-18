package company.u51._20170918._01;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            String result = process(s);
            System.out.println(result);
        }
    }

    private static String process(String s) {
        Character[] cArr = new Character[s.length()];
        StringBuilder numStr = new StringBuilder();
        char c;
        int index = 0;
        for (int i = 0, len = s.length(); i < len; ++i) {
            c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numStr.append(c);
            } else {
                cArr[index++] = c;
            }
        }
        Arrays.sort(cArr, 0, index, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                Character no1 = o1;
                Character no2 = o2;
                if (no1 >= 'A' && no1 <= 'Z') {
                    no1 = (char)(no1 - 'A' + 'a');
                }
                if (no2 >= 'A' && no2 <= 'Z') {
                    no2 = (char)(no2 - 'A' + 'a');
                }
                return no1.compareTo(no2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; ++i) {
            sb.append(cArr[i]);
        }
        return sb.append(numStr).toString();
    }
}
