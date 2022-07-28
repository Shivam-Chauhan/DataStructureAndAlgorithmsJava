public class knapSack {
    static int knapSackFinder(int[] weight, int[] value, int index, int totalWeight, int[][] grid) {
        if (index == 0) {
            if (weight[0] <= totalWeight) return value[0];
            return 0;
        }
        if (grid[index][totalWeight] != -1) return grid[index][totalWeight];
        int notPick = knapSackFinder(weight, value, index - 1, totalWeight, grid);
        int pickIt = Integer.MIN_VALUE;
        if (weight[index] <= totalWeight) {
            pickIt = value[index] + knapSackFinder(weight, value, index - 1, totalWeight - weight[index], grid);
        }
        return grid[index][totalWeight] = Math.max(notPick, pickIt);
    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] grid = new int[n][maxWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxWeight; j++) grid[i][j] = -1;
        }
        return knapSackFinder(weight, value, weight.length - 1, maxWeight, grid);
    }
}
