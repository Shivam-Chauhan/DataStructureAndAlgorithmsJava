public class maxAreaIsland {
    public void maxAreaFinder(int[][] grid,int xaxis,int yaxis,int[] counter){
        if(xaxis<0 || xaxis>=grid.length || yaxis<0 || yaxis>=grid[0].length || grid[xaxis][yaxis]==0){
            return;
        }
        grid[xaxis][yaxis]=0;
        counter[0]+=1;
        maxAreaFinder(grid,xaxis+1,yaxis,counter);
        maxAreaFinder(grid,xaxis,yaxis+1,counter);
        maxAreaFinder(grid,xaxis,yaxis-1,counter);
        maxAreaFinder(grid,xaxis-1,yaxis,counter);
    }
    public static void main(String[] args) {
        maxAreaIsland obj=new maxAreaIsland();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int maxiArea=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int[] counter=new int[1];
                    obj.maxAreaFinder(grid,i,j,counter);
                    maxiArea=Math.max(maxiArea,counter[0]);
                }
            }
        }
        System.out.println(maxiArea);

    }
}
