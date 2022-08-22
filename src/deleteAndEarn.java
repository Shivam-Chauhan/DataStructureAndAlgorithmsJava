public class deleteAndEarn {
    // ------*------*------*------*------*------*------*------*------*------*------*------*------*------*------*------*-
    // Time Complexity :- O(N)
    // Space Complexity :- O(Maxi(Array)) + Auxillary Space Of Recursion Stack
    // Link :- https://leetcode.com/problems/delete-and-earn/
    public int deleteAndEarnFinderMemo(int[] nums, int index, int[] grid) {
        if (index >= nums.length) return 0;
        if (grid[index] != -1) return grid[index];
        return grid[index] = Math.max(
                deleteAndEarnFinderMemo(nums, index + 1, grid),
                nums[index] * index + deleteAndEarnFinderMemo(nums, index + 2, grid));
    }

    public int deleteAndEarnMemo(int[] nums) {
        int maxiNumber = Integer.MIN_VALUE;
        for (int i : nums) maxiNumber = Math.max(i, maxiNumber);
        int[] dp = new int[maxiNumber + 1];
        int[] grid = new int[maxiNumber + 1];
        for (int i : nums) dp[i] += 1;
        for (int i = 0; i < maxiNumber + 1; i++) grid[i] = -1;
        return deleteAndEarnFinderMemo(dp, 0, grid);
    }

    // ------*------*------*------*------*------*------*------*------*------*------*------*------*------*------*------*-
    // Time Complexity :- O(N)
    // Space Complexity :- O(Maxi(Array))
    // Link :- https://leetcode.com/problems/delete-and-earn/
    public int deleteAndEarnTabulation(int[] nums) {
        int maxiNumber = Integer.MIN_VALUE;
        for (int i : nums) maxiNumber = Math.max(i, maxiNumber);
        int[] dp = new int[maxiNumber + 1];
        int[] grid = new int[maxiNumber + 1];
        for (int i : nums) dp[i] += 1;
        for (int i = 0; i < maxiNumber + 1; i++) grid[i] = -1;
        for (int index = maxiNumber; index >= 0; index--) {
            int notPick = index + 1 <= maxiNumber ? grid[index + 1] : 0;
            int pick = dp[index] * index + (index + 2 <= maxiNumber ? grid[index + 2] : 0);
            grid[index] = Math.max(notPick, pick);
        }
        return grid[0];
    }

    // ------*------*------*------*------*------*------*------*------*------*------*------*------*------*------*------*-
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    // Link :- https://leetcode.com/problems/delete-and-earn/
    public int deleteAndEarnSpaceOpti(int[] nums) {
        int maxiNumber = Integer.MIN_VALUE;
        for (int i : nums) maxiNumber = Math.max(i, maxiNumber);
        int[] dp = new int[maxiNumber + 1];
        int first = 0, second = 0;
        for (int i : nums) dp[i] += 1;
        for (int index = maxiNumber; index >= 0; index--) {
            int notPick = first;
            int pick = dp[index] * index + second;
            int curr = Math.max(notPick, pick);
            second = first;
            first = curr;
        }
        return first;
    }
}
