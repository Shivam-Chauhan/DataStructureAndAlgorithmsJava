public class minPathSum {
    public static int minPathFinder(int[][] grid, int[][] storage, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    storage[i][j] = grid[i][j];
                } else if (i == row - 1) {
                    storage[i][j] = grid[i][j] + storage[i][j + 1];
                } else if (j == col - 1) {
                    storage[i][j] = grid[i][j] + storage[i + 1][j];
                } else {
                    storage[i][j] = grid[i][j] + Math.min(storage[i + 1][j], storage[i][j + 1]);
                }
            }
        }
        return storage[0][0];
    }

    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N)
    public static int minSumPath(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] storage = new int[row][col];
        return minPathFinder(grid, storage, row, col);
    }
}
