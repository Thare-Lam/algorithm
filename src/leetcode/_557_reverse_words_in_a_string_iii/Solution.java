package leetcode._557_reverse_words_in_a_string_iii;

public class Solution {

    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int i, len, start = 0;
        for(i = 0, len = charArray.length; i < len; i++) {
            if (charArray[i] == ' ') {
                reserve(charArray, start, i - 1);
                start = i + 1;
            }
        }
        reserve(charArray, start, len - 1);
        return String.valueOf(charArray);
    }

    private void reserve(char[] charArray, int start, int end) {
        char temp;
        while(start < end) {
            temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }

}
