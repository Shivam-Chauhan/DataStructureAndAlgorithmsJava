public class partitionArrayMaximumSum {
    // Time Complexity :- O(N*M))
    // Space Complexity :- O(N) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/partition-array-for-maximum-sum/
    public int maxSumFinder(int[] arr, int k, int index, int[] dp) {
        if (index == arr.length) return 0;
        if (dp[index] != -1) return dp[index];
        int windowLength = 0, maxi = (int) -1e9, overMax = 0;
        for (int i = index; i < Math.min(arr.length, index + k); i++) {
            windowLength++;
            maxi = Math.max(maxi, arr[i]);
            int summation = windowLength * maxi + maxSumFinder(arr, k, i + 1, dp);
            overMax = Math.max(overMax, summation);
        }
        return dp[index] = overMax;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) dp[i] = -1;
        return maxSumFinder(arr, k, 0, dp);
    }
}
