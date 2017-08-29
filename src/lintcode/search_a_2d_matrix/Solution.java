package lintcode.search_a_2d_matrix;

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int column = matrix[0].length;
        if (column == 0) {
            return false;
        }
        int x = 0;
        int y = column - 1;
        while (x < row && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }
}
