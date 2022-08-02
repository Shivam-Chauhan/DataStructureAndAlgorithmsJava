public class twoKeysKeyboard {
    // -------------------------------*---------------------------*---------------------------------------------------
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N)
    // Link :- https://leetcode.com/problems/2-keys-keyboard/
    public int minStepsFinder(int counter, int n,int prev,int[][] dp){
        if(counter>n) return (int)1e9;
        if(counter==n) return 0;
        if(dp[counter][prev]!=0) return dp[counter][prev];
        int copy=2+minStepsFinder(counter+counter,n,counter,dp);
        int paste=1+minStepsFinder(counter+prev,n,prev,dp);
        return dp[counter][prev]=Math.min(copy,paste);

    }
    public int minSteps(int n) {
        int[][] dp=new int[n+1][n+1];
        return n>1?1+minStepsFinder(1,n,1,dp):0;
    }
}
