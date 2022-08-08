public class countSubIslands {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/count-sub-islands/
    public void dfs(int[][] grid1, int[][] grid2, int row, int col, boolean[] isSubIsland,
                    int[][] visited) {
        if (row < 0 || row >= grid1.length || col < 0 || col >= grid1[0].length || visited[row][col] == 1 || grid2[row][col] == 0)
            return;
        if (grid2[row][col] == 1 && grid1[row][col] == 0) {
            isSubIsland[0] = true;
        }
        visited[row][col] = 1;
        dfs(grid1, grid2, row + 1, col, isSubIsland, visited);
        dfs(grid1, grid2, row, col + 1, isSubIsland, visited);
        dfs(grid1, grid2, row - 1, col, isSubIsland, visited);
        dfs(grid1, grid2, row, col - 1, isSubIsland, visited);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int counter = 0;
        int[][] visited = new int[grid1.length][grid1[0].length];
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && visited[i][j] == 0) {
                    boolean[] isSubIsland = new boolean[1];
                    isSubIsland[0] = false;
                    dfs(grid1, grid2, i, j, isSubIsland, visited);
                    if (isSubIsland[0] == false) counter++;
                }
            }
        }
        return counter;
    }
}
