import java.util.List;

public class triangle {
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/triangle/
    public int minTotalPath(List<List<Integer>> triangle, int row, int col, int rowLength, int[][] grid) {
        if (row == triangle.size() - 1) return triangle.get(row).get(col);
        if (row >= rowLength || col >= triangle.get(row).size()) return (int) 1e9;
        if (grid[row][col] != (int) 1e9) return grid[row][col];
        int down = triangle.get(row).get(col) + minTotalPath(triangle, row + 1, col, rowLength, grid);
        int diagonal = triangle.get(row).get(col) + minTotalPath(triangle, row + 1, col + 1, rowLength, grid);
        return grid[row][col] = Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = (int) 1e9;
        return minTotalPath(triangle, 0, 0, n, grid);
    }
}
