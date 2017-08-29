package lintcode.first_position_unique_character;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        if (s == null || s.equals("")) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        Set<Character> set1 = new TreeSet<Character>();
        Set<Character> set2 = new TreeSet<Character>();
        char c;
        int i;
        int len;
        len = s.length();
        for (i = 0; i < len; ++i) {
            c = s.charAt(i);
            if (set1.contains(c)) {
                set2.add(c);
            } else {
                set1.add(c);
            }
        }
        for (i = 0; i < len; ++i) {
            c = s.charAt(i);
            if (!set2.contains(c)) {
                return i;
            }
        }
        return -1;
    }
}
