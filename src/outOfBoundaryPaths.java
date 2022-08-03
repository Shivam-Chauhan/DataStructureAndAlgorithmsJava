public class outOfBoundaryPaths {
    // Time Complexity :- O(MaxMove*N*M))
    // Space Complexity :- O(MaxMove*N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/out-of-boundary-paths/
    public int findPathFinder(int m, int n, int maxMoves, int moves, int row, int col, int mod, int[][][] grid) {
        if (row >= m || row < 0 || col >= n || col < 0) return 1;
        if (moves == maxMoves) return 0;
        if (grid[moves][row][col] != -1) return grid[moves][row][col];
        int ans = 0;
        ans = (ans + findPathFinder(m, n, maxMoves, moves + 1, row + 1, col, mod, grid)) % mod;
        ans = (ans + findPathFinder(m, n, maxMoves, moves + 1, row - 1, col, mod, grid)) % mod;
        ans = (ans + findPathFinder(m, n, maxMoves, moves + 1, row, col + 1, mod, grid)) % mod;
        ans = (ans + findPathFinder(m, n, maxMoves, moves + 1, row, col - 1, mod, grid)) % mod;
        return grid[moves][row][col] = ans % mod;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] grid = new int[maxMove][m][n];
        for (int i = 0; i < maxMove; i++)
            for (int j = 0; j < m; j++)
                for (int k = 0; k < n; k++)
                    grid[i][j][k] = -1;
        return findPathFinder(m, n, maxMove, 0, startRow, startColumn, 1000000007, grid);

    }
}
