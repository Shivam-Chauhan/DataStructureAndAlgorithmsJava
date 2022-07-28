public class coinChange {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://leetcode.com/problems/coin-change/
    public int coinChangeFinder(int[] coins,int target, int index,int[][] grid){
        if(index==0){
            if(target%coins[0]==0)
                return target/coins[0];
            return (int)1e9;
        }
        if(grid[index][target]!=-1) return grid[index][target];
        int notPick=coinChangeFinder(coins,target, index-1,grid);
        int pick=Integer.MAX_VALUE;
        if(coins[index]<=target){
            pick=1+coinChangeFinder(coins, target-coins[index],index,grid);
        }
        return grid[index][target]=Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int[][] grid=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++) grid[i][j]=-1;
        }
        int ans=coinChangeFinder(coins, amount,coins.length-1,grid);
        return ans>=(int)1e9?-1:ans;
    }
}
