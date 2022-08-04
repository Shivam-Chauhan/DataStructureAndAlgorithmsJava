public class numberOfDiceWithTargetSum {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
    int MOD = 1000000007;
    public int numFinder(int dice, int face, int target, int[][] grid) {
        if (dice == 0 && target == 0) return 1;
        if (dice <= 0 || target <= 0) return 0;
        if (grid[dice][target] != -1) return grid[dice][target];
        int counter = 0;
        for (int i = 1; i <= face; i++)
            counter = ((counter % MOD) + (numFinder(dice - 1, face, target - i, grid) % MOD)) % MOD;
        return grid[dice][target] = counter;

    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] grid = new int[n + 1][target + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < target + 1; j++)
                grid[i][j] = -1;
        return numFinder(n, k, target, grid) % MOD;
    }
}
