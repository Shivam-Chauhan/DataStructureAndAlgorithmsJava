public class minCostClimbingStairs {

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(2^N)
    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
    public int minCostFinder(int[] cost, int index) {
        if (index == 0 || index == 1) return cost[index];
        if (index < 0) return (int) 1e9;
        return cost[index] + Math.min(minCostFinder(cost, index - 1), minCostFinder(cost, index - 2));

    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N)
    // Space Complexity :- O(N) + Auxillary Space Of Recursion Stack
    public int minCostFinderBetter(int[] cost, int index, int[] dp) {
        if (index == 0 || index == 1) return cost[index];
        if (index < 0) return (int) 1e9;
        if (dp[index] != 0) return dp[index];
        return dp[index] = cost[index] + Math.min(
                minCostFinderBetter(cost, index - 1, dp),
                minCostFinderBetter(cost, index - 2, dp));

    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N)
    // Space Complexity :- O(N)
    public int minCostFinderTabulation(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N)
    // Space Complexity :- O(1)
    public int minCostFinderSpaceOptimization(int[] cost) {
        int[] dp = new int[cost.length];
        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < dp.length; i++) {
            int temp = cost[i] + Math.min(first, second);
            first = second;
            second = temp;
        }
        return Math.min(first, second);
    }

    public int minCostClimbingStairs(int[] cost) {
//         Recursive Solution
//         return Math.min(minCostFinder(cost, cost.length-1),minCostFinder(cost, cost.length-2));

//         Memoization
//        int[] dp=new int[cost.length+1];
//        return Math.min(
//                minCostFinderBetter(cost, cost.length-1,dp),
//                minCostFinderBetter(cost, cost.length-2,dp));

//          Tabulation
//        return minCostFinderTabulation(cost);

//          Space Optimization
        return minCostFinderSpaceOptimization(cost);
    }
}
