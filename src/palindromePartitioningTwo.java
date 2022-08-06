public class palindromePartitioningTwo {
    // Time Complexity :- O(N*M*N))
    // Space Complexity :- O(N) + Auxillary Space Of Recursion Stack
    // Link:- https://leetcode.com/problems/palindrome-partitioning-ii/
    public boolean isPalindrome(String string, int left, int right) {
        while (left < right) {
            if (string.charAt(left++) != string.charAt(right--)) return false;
        }
        return true;
    }

    public int minCutFinder(String string, int left, int[] dp) {
        if (left >= string.length()) return 0;
        if (dp[left] != -1) return dp[left];
        int minValue = (int) 1e9;
        for (int index = left; index < string.length(); index++) {
            if (isPalindrome(string, left, index)) {
                int cost = 1 + minCutFinder(string, index + 1, dp);
                minValue = Math.min(minValue, cost);
            }
        }
        return dp[left] = minValue;
    }

    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            dp[i] = -1;
        return minCutFinder(s, 0, dp) - 1;

    }

}
