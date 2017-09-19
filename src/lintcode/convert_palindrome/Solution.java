package lintcode.convert_palindrome;

public class Solution {

    /*
     * @param : String
     * @return: String
     */
    public String convertPalindrome(String str) {
        StringBuilder sb = new StringBuilder();
        int end = str.length() - 1;
        while (!isHw(str, end)) {
            sb.append(str.charAt(end--));
        }
        return sb.append(str).toString();
    }

    private boolean isHw(String str, int end) {
        int i = 0, j = end;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertPalindrome("sdsdlkjsaoio"));
    }

}
