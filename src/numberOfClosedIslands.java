public class numberOfClosedIslands {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/number-of-closed-islands/
    public int dfs(int[][] grid, int x, int y) {
        if (Math.min(x, y) < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) return 0;
        grid[x][y] = 1;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);

    }

    public int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                if (i * j * (i - grid.length + 1) * (j - grid[i].length + 1) == 0) dfs(grid, i, j);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) result += dfs(grid, i, j) > 0 ? 1 : 0;
            }
        }
        return result;
    }
}
