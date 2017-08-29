package lintcode.reverse_words_in_a_string;

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        char[] str = s.trim().toCharArray();
        int len = str.length;
        if (len == 0) {
            return "";
        }
        int left = -1;
        int cursor = len - 1;
        int i;
        reversePart(str, 0, len - 1);
        for (i = 0; i < len; i++) {
            if (str[i] == ' ') {
                if (left >= 0) {
                    reversePart(str, left, --i);
                    left = -1;
                }
            } else if (left < 0) {
                left = i;
            }
        }
        reversePart(str, left, len - 1);
        for (i = len - 1; i >= 0; --i) {
            if (str[i] != ' ') {
                str[cursor--] = str[i];
            } else {
                if (str[cursor + 1] != ' ') {
                    str[cursor--] = str[i];
                }
            }
        }
        return new String(str, cursor + 1, len - cursor - 1);
    }

    private void reversePart(char[] str, int left, int right) {
        char c;
        for (int i = left, j = right; i < j; ++i, --j) {
            c = str[i];
            str[i] = str[j];
            str[j] = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(
        new Solution().reverseWords("I love to walk around in bookstores       not because I can buy all the books"));
    }
}
