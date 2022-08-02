public class minFallingSum {
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- M*O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/2-keys-keyboard/
    public int minFallingSumFinder(int[][] matrix, int row, int col, int[][] grid) {
        if (row >= matrix.length || col < 0 || col >= matrix[0].length) return (int) 1e9;
        if (row == matrix.length - 1) return matrix[row][col];
        if (grid[row][col] != 0) return grid[row][col];
        int down = matrix[row][col] + minFallingSumFinder(matrix, row + 1, col, grid);
        int right = matrix[row][col] + minFallingSumFinder(matrix, row + 1, col + 1, grid);
        int left = matrix[row][col] + minFallingSumFinder(matrix, row + 1, col - 1, grid);
        return grid[row][col] = Math.min(down, Math.min(right, left));
    }

    public int minFallingPathSum(int[][] matrix) {
        int minValue = (int) 1e9;
        for (int col = 0; col < matrix[0].length; col++) {
            int[][] grid = new int[matrix.length][matrix.length];
            minValue = Math.min(minValue, minFallingSumFinder(matrix, 0, col, grid));
        }
        return minValue;
    }
}
