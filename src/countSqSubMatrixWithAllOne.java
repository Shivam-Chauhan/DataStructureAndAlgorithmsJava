public class countSqSubMatrixWithAllOne {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/partition-array-for-maximum-sum/
    public int countSqFinder(int[][] matrix) {
        int x = matrix.length, y = matrix[0].length;
        int[][] grid = new int[x][y];
        int summation = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) grid[i][j] = 1;
                    else {
                        grid[i][j] = 1 + Math.min(grid[i - 1][j], Math.min(grid[i][j - 1], grid[i - 1][j - 1]));
                    }
                }
                summation += grid[i][j];
            }
        }
        return summation;
    }
    public int countSquares(int[][] matrix) {
        return countSqFinder(matrix);
    }
}
