public class lastStoneWeightTwo {
    public int summer(int[] stones, int index, int summation, int target, int[][] grid) {
        if (index == stones.length) {
            int ans = summation - 2 * target;
            if (ans < 0) return (int) 1e9;
            return ans;
        }
        if (grid[index][target] != -1) return grid[index][target];
        int notPick = summer(stones, index + 1, summation, target, grid);
        int pick = (int) 1e9;
        if (target + stones[index] <= summation) {
            pick = summer(stones, index + 1, summation, target + stones[index], grid);
        }
        return grid[index][target] = Math.min(pick, notPick);
    }

    // Time Complexity :- O(N*Log(N))
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    // Link:-  https://leetcode.com/problems/last-stone-weight-ii/
    public int lastStoneWeightII(int[] stones) {
        int summation = 0;
        int[][] grid = new int[stones.length][3001];
        for (int i : stones) summation += i;
        for (int i = 0; i < stones.length; i++)
            for (int j = 0; j < 3001; j++)
                grid[i][j] = -1;
        return summer(stones, 0, summation, 0, grid);
    }
}
