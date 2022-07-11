public class numberOfIslands {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    public void dfsTraversal(char[][] grid,int xindex, int yindex){
        if(xindex<0 || xindex>=grid.length || yindex<0 || yindex>=grid[0].length || grid[xindex][yindex]!='1') return;

        grid[xindex][yindex]='0';
        dfsTraversal(grid,xindex+1,yindex);
        dfsTraversal(grid,xindex-1,yindex);
        dfsTraversal(grid,xindex,yindex+1);
        dfsTraversal(grid,xindex,yindex-1);
    }
    public static void main(String[] args) {
        numberOfIslands obj=new numberOfIslands();
        char[][] grid={{'1','1','1','1','0'},
                       {'1','1','0','1','0'},
                       {'1','1','0','0','0'},
                       {'0','0','0','0','0'}};
        
        int counter=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    counter++;
                    obj.dfsTraversal(grid,i,j);
                }
            }
        }
        System.out.println(counter);
    }
}
