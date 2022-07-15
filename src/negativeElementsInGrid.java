public class negativeElementsInGrid {
    // Time Complexity :- ~ O(N+M)
    // Space Complexity :- O(1)
    public int countNegatives(int[][] grid) {
        int col=grid[0].length, row=grid.length-1, colCt=0, result=0;
        while(row>=0 && colCt<col){
            if(grid[row][colCt]<0){
                row--;
                result+=col-colCt;
            }
            else{
                colCt++;
            }
        }
        return result;
    }
}
