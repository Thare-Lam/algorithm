package lintcode.wildcard_matching;

public class Solution2 {
    /*
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        int indexS = 0;
        int indexP = 0;
        int indexStar = -1;
        int indexBackupS = 0;
        int lenS = s.length();
        int lenP = p.length();
        while (indexS < lenS) {
            if (indexP < lenP && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
                ++indexS;
                ++indexP;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                indexStar = indexP;
                ++indexP;
                indexBackupS = indexS;
            } else if (indexStar >= 0) {
                indexP = indexStar + 1;
                ++indexBackupS;
                indexS = indexBackupS;
            } else {
                return false;
            }
        }
        while (indexP < lenP && p.charAt(indexP) == '*') {
            ++indexP;
        }
        return indexP == lenP;
    }
}
