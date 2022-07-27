public class uniquePathsDP {
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    public static int gridPathFinder(int m, int n, int[][] grid) {
        if (n == 0 && m == 0) return 1;
        if (n < 0 || m < 0) return 0;
        if (grid[m][n] != -1) return grid[m][n];
        return grid[m][n] = gridPathFinder(m - 1, n, grid) + gridPathFinder(m, n - 1, grid);
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) grid[i][j] = -1;
        }
        return gridPathFinder(m - 1, n - 1, grid);
    }
}
