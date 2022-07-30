public class rodCutting {
    public static int cutRodFinder(int[] price, int index, int lengthLeft, int[][] grid) {
        if (index == 0) return lengthLeft * price[0];
        if (grid[index][lengthLeft] != -1) return grid[index][lengthLeft];
        int notTake = cutRodFinder(price, index - 1, lengthLeft, grid);
        int rodLength = index + 1;
        int take = Integer.MIN_VALUE;
        if (rodLength <= lengthLeft) take = price[index] + cutRodFinder(price, index, lengthLeft - rodLength, grid);
        return grid[index][lengthLeft] = Math.max(take, notTake);

    }
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int cutRod(int[] price, int n) {
        int[][] grid = new int[n][n + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) grid[i][j] = -1;
        }
        return cutRodFinder(price, price.length - 1, n, grid);
    }
}
