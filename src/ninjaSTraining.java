public class ninjaSTraining {
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N*N)
    // Link :- https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
    public static int ninjaTrainingFinder(int[][] points, int[][] grid){
        int maxResult=Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points[0].length;j++){
                if(i==0) grid[i][j]=points[i][j];
                else {
                    if (j == 0) grid[i][j] = points[i][j] + Math.max(grid[i - 1][1], grid[i - 1][2]);
                    else if (j == 1) grid[i][j] = points[i][j] + Math.max(grid[i - 1][2], grid[i - 1][0]);
                    else if (j == 2) grid[i][j] = points[i][j] + Math.max(grid[i - 1][1], grid[i - 1][0]);
                }
                maxResult=Math.max(maxResult, grid[i][j]);
            }

        }
        return maxResult;
    }
    // Time Complexity :- O(N*N)
    // Space Complexity :- O(N)
    public static int ninjaTrainingFinderOptimal(int[][] points){
        int[] grid=new int[points[0].length];
        int maxResult=Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            int[] temp=new int[points[0].length];
            for(int j=0;j<points[0].length;j++){
                if(i==0) temp[j]=points[i][j];
                else{
                    if(j==0) temp[j]=points[i][j]+Math.max(grid[1], grid[2]);
                    else if(j==1) temp[j]=points[i][j]+Math.max(grid[2], grid[0]);
                    else if(j==2) temp[j]=points[i][j]+Math.max(grid[1], grid[0]);
                }
                maxResult=Math.max(maxResult, temp[j]);
            }
            grid=temp;
        }
        return maxResult;
    }
}
