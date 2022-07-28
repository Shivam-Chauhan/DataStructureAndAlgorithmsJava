public class numberOfSubsetSumK {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M) + Auxillary Space Of Recursion Stack
    // link :- https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
    public static int subSetSumFinder(int[] arr, int target, int index,int[][] grid){
        if(index==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || target==arr[0]) return 1;
            return 0;
        }
        if(grid[index][target]!=-1) return grid[index][target];
        int taker=0;
        if(arr[index]<=target){
            taker=subSetSumFinder(arr, target-arr[index], index-1,grid);
        }
        int notTaker=subSetSumFinder(arr, target, index-1,grid);
        return grid[index][target]=taker+notTaker;
    }
    public static int findWays(int arr[], int tar) {
        int k=tar;
        int[][] grid=new int[arr.length][k+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=k;j++) grid[i][j]=-1;
        }
        return subSetSumFinder(arr,k,arr.length-1,grid);
    }
}
