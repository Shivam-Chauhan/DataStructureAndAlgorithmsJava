public class uniqueBinarySearchTree {
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N)
    // Link:- https://leetcode.com/problems/unique-binary-search-trees/
    public void catalanNumberFinder(int n, int[] dp) {
        for (int i = 0; i < n; i++) {
            dp[n] += dp[i] * dp[n - 1 - i];
        }
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            catalanNumberFinder(i, dp);
        }
        return dp[n];
    }
}
