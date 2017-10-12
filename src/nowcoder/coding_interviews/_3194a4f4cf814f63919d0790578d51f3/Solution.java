package nowcoder.coding_interviews._3194a4f4cf814f63919d0790578d51f3;

public class Solution {

    public String ReverseSentence(String str) {
        char[] s = str.toCharArray();
        reverse(s, 0, s.length - 1);
        int i, j;
        for (i = 0; i < s.length; ++i) {
            if (s[i] != ' ') {
                for (j = i + 1; j < s.length; ++j) {
                    if (s[j] == ' ') {
                        reverse(s, i, j - 1);
                        break;
                    }
                    if (j == s.length - 1) {
                        reverse(s, i, j);
                    }
                }
                i = j;
            }
        }
        return String.valueOf(s);
    }

    private void reverse(char[] s, int start, int end) {
        char c;
        for (int i = start, j = end; i < j; ++i, --j) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }

    public static void main(String[] args) {
        new Solution().ReverseSentence("Hello World!");
    }

}
