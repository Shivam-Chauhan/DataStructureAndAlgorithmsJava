public class subSetSumEqualToK {
    public static boolean subSetSumFinder(int[] arr, int target, int index,int[][] grid){
        if(target==0) return true;
        if(index==0) return arr[0]==target;
        if(grid[index][target]!=-1) return grid[index][target]==0?false:true;
        boolean taker=false;
        if(arr[index]<=target){
            taker=subSetSumFinder(arr, target-arr[index], index-1,grid);
        }
        boolean notTaker=subSetSumFinder(arr, target, index-1,grid);
        grid[index][target]=(taker | notTaker)==false?0:1;
        return taker|notTaker;
    }
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] grid=new int[arr.length][k+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=k;j++) grid[i][j]=-1;
        }
        return subSetSumFinder(arr,k,arr.length-1,grid);
    }
}
