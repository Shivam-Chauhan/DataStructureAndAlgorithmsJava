public class triangleDP {
    public static int minPathSumTriangleFinder(int[][] triangle, int row, int col, int n, int[][] grid) {
        if (row == n - 1) return triangle[row][col];
        if (grid[row][col] != -1) return grid[row][col];
        int down = triangle[row][col] + minPathSumTriangleFinder(triangle, row + 1, col, n, grid);
        int diagonal = triangle[row][col] + minPathSumTriangleFinder(triangle, row + 1, col + 1, n, grid);
        return grid[row][col] = Math.min(down, diagonal);
    }

    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int minimumPathSum(int[][] triangle, int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) grid[i][j] = -1;
        }
        return minPathSumTriangleFinder(triangle, 0, 0, n, grid);
    }
}
