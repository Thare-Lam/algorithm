package lintcode.rotate_string;

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        int len = str.length;
        if (len == 0) {
            return;
        }
        offset = offset % len;
        reversePart(str, 0, len - 1);
        reversePart(str, 0, offset - 1);
        reversePart(str, offset, len - 1);
    }

    private void reversePart(char[] str, int start, int end) {
        char c;
        for (int i = start, j = end; i < j; ++i, --j) {
            c = str[i];
            str[i] = str[j];
            str[j] = c;
        }
    }
}
