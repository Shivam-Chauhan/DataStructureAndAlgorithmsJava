public class partitionSubSetWithMinAbsDiff {

    public static void subSetSumFinder(int[] arr, int target, int[][] grid) {
        for (int i = 0; i < grid.length; i++) grid[i][0] = 1;
        if (arr[0] <= target) grid[0][arr[0]] = 1;
        for (int index = 1; index < grid.length; index++) {
            for (int sum = 0; sum <= target; sum++) {
                boolean nottake = grid[index - 1][sum] == 0 ? false : true;
                boolean take = false;
                if (arr[index] <= sum) {
                    take = grid[index - 1][sum - arr[index]] == 1 ? true : false;
                }
                grid[index][sum] = (nottake | take) == false ? 0 : 1;
            }
        }
    }

    public static int minimalFinder(int[][] grid, int summation) {
        int minAbsResult = (int) 1e8;
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[grid.length - 1][col] == 1) {
                minAbsResult = Math.min(minAbsResult, Math.abs((summation - col) - col));
            }
        }
        return minAbsResult;
    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int minSubsetSumDifference(int[] arr, int n) {
        int summation = 0;
        for (int i : arr) summation += i;
        int[][] grid = new int[arr.length][summation + 1];
        subSetSumFinder(arr, summation, grid);
        return minimalFinder(grid, summation);
    }
}
