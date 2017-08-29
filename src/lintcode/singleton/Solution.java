package lintcode.singleton;

public class Solution {

    private static Solution instance;
    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
}
