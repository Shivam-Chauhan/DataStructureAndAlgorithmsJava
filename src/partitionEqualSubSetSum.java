public class partitionEqualSubSetSum {
    public static boolean subSetSumFinder(int[] arr, int target, int index, int[][] grid) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;
        if (grid[index][target] != -1) return grid[index][target] == 0 ? false : true;
        boolean taker = false;
        if (arr[index] <= target) {
            taker = subSetSumFinder(arr, target - arr[index], index - 1, grid);
        }
        boolean notTaker = subSetSumFinder(arr, target, index - 1, grid);
        grid[index][target] = (taker | notTaker) == false ? 0 : 1;
        return taker | notTaker;
    }

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static boolean canPartition(int[] arr, int n) {
        int k = 0;
        for (int i : arr) k += i;
        if (k % 2 == 1) return false;
        k /= 2;
        int[][] grid = new int[arr.length][k + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= k; j++) grid[i][j] = -1;
        }
        return subSetSumFinder(arr, k, arr.length - 1, grid);
    }
}
