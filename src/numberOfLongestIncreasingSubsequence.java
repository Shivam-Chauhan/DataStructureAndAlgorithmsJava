public class numberOfLongestIncreasingSubsequence {

    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/number-of-longest-increasing-subsequence/
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        int maxi = 1, countVal = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            counter[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    // Basic LIS Code
                    dp[i] = dp[j] + 1;
                    counter[i] = counter[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    // For counting the number of subsequence having the same length
                    counter[i] += counter[j];
                }
            }
            maxi = Math.max(maxi, dp[i]);

        }
        for (int i = 0; i < nums.length; i++) {
            if (maxi == dp[i]) countVal += counter[i];
        }
        return countVal;
    }
}
g