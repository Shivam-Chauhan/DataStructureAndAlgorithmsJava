public class unBoundedKnapSack {
    public static int maxiFinder(int[] profit, int[] weight, int weightLeft, int index, int[][] grid) {
        if (index == 0)
            return (weightLeft / weight[0]) * profit[0];
        if (grid[index][weightLeft] != -1) return grid[index][weightLeft];
        int notTake = maxiFinder(profit, weight, weightLeft, index - 1, grid);
        int take = 0;
        if (weight[index] <= weightLeft)
            take = profit[index] + maxiFinder(profit, weight, weightLeft - weight[index], index, grid);
        return grid[index][weightLeft] = Math.max(take, notTake);
    }
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] grid = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) grid[i][j] = -1;
        }
        return maxiFinder(profit, weight, w, weight.length - 1, grid);
    }
}
