public class perfectSquares {
    public int perfectSquareFinder(int target, int index, int[][] grid) {
        if (target == 0) return 0;
        if (target < 0 || index == 0) return (int) 1e9;
        if (grid[index][target] != -1) return grid[index][target];
        int notPick = perfectSquareFinder(target, index - 1, grid);
        int pick = (int) 1e9;
        if (index * index <= target) {
            pick = 1 + perfectSquareFinder(target - index * index, index, grid);
        }
        return grid[index][target] = Math.min(notPick, pick);
    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/perfect-squares/
    public int numSquares(int n) {
        int i = 0;
        while (i * i <= n) {
            i++;
        }
        int[][] grid = new int[i + 1][n + 1];
        for (int j = 0; j <= i; j++)
            for (int k = 0; k <= n; k++)
                grid[j][k] = -1;
        return perfectSquareFinder(n, i, grid);

    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    // Link :- https://leetcode.com/problems/perfect-squares/
    public int perfectSquareFinderOptimal(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            int j = 1, miniVal = (int) 1e9;
            while (j * j <= i) {
                miniVal = Math.min(miniVal, dp[i - j * j]);
                j++;
            }
            dp[i] = 1 + miniVal;
        }
        return dp[target];
    }
}
