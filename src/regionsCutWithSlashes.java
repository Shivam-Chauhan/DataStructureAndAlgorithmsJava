public class regionsCutWithSlashes {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    // Link :- https://leetcode.com/problems/regions-cut-by-slashes/
    // Sol Link :- https://leetcode.com/problems/regions-cut-by-slashes/discuss/205674/DFS-on-upscaled-grid
    public int dfs(int[][] grid, int x, int y) {
        if (Math.min(x, y) < 0 || Math.max(x, y) >= grid.length || grid[x][y] != 0) return 0;
        grid[x][y] = 1;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }

    public int regionsBySlashes(String[] matrix) {
        int n = matrix.length, result = 0;
        int[][] grid = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '/') {
                    grid[i * 3][j * 3 + 2] = grid[i * 3 + 1][j * 3 + 1] = grid[i * 3 + 2][j * 3] = 1;
                } else if (matrix[i].charAt(j) == '\\') {
                    grid[i * 3][j * 3] = grid[i * 3 + 1][j * 3 + 1] = grid[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                result += dfs(grid, i, j) > 0 ? 1 : 0;
            }
        }
        return result;

    }
}
