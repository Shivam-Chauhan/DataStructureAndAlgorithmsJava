public class cherryPickUpTwo {
    // Time Complexity :- O(N*M*M)
    // Space Complexity :- O(N*M*M) + Auxillary Space Of Recursion Stack
    // link :- https://leetcode.com/problems/cherry-pickup-ii/
    public int cherryPickFinder(int[][] grid, int row, int col1, int col2,int[][][] storage){
        if(col1<0 || col2<0 || col1>=grid[0].length || col2>=grid[0].length){
            return (int)-1e8;
        }
        if(row==grid.length-1){
            if(col1==col2) return grid[row][col1];
            else return grid[row][col1]+grid[row][col2];
        }
        if(storage[row][col1][col2]!=-1) return storage[row][col1][col2];
        int maxValue=(int)-1e8;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int value=0;
                if(col1==col2) value+=grid[row][col1];
                else value+=grid[row][col1]+grid[row][col2];
                value+=cherryPickFinder(grid,row+1,col1+i,col2+j,storage);
                maxValue=Math.max(maxValue, value);
            }
        }
        return storage[row][col1][col2]=maxValue;
    }
    public int cherryPickup(int[][] grid) {
        int r=grid.length, c=grid[0].length;
        int[][][] storage=new int[r][c][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int k=0;k<c;k++) storage[i][j][k]=-1;
            }
        }
        return cherryPickFinder(grid,0,0,c-1, storage);
    }
}
