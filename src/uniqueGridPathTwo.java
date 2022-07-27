import java.util.ArrayList;
public class uniqueGridPathTwo {

    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack

    public static int gridPathFinder(int n, int m, int[][] grid, ArrayList<ArrayList<Integer>> mat) {
        if(n>=0 && m>=0 && mat.get(n).get(m)==-1) return 0;
        if (n == 0 && m == 0) return 1;
        if (n < 0 || m < 0) return 0;
        if (grid[n][m] != -1) return grid[n][m];
        return grid[n][m] = (gridPathFinder(n - 1, m, grid,mat) + gridPathFinder(n, m - 1, grid,mat))%(1000000007);
    }
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) grid[i][j] = -1;
        }
        return gridPathFinder(n - 1, m - 1, grid, mat);
    }
}
