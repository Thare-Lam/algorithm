package lintcode.search_a_2d_matrix_ii;

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int column = matrix[0].length;
        if (column == 0) {
            return 0;
        }
        int x = 0;
        int y = column - 1;
        int count = 0;
        while (x < row && y >= 0) {
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                count++;
                x++;
                y--;
            }
        }
        return count;
    }
}
