import java.util.LinkedList;
import java.util.Queue;

// Time Complexity :- O(N*M)
// Space Complexity :- O(N*M)
public class shortestBridge {
    public void dfsTraversal(int[][] grid,int xindex, int yindex, Queue<int[]>queue, int[][] visited){
        if(xindex<0 || xindex>=grid.length || yindex<0 || yindex>=grid[0].length || visited[xindex][yindex]==1 ||
                grid[xindex][yindex]==0) return;

        visited[xindex][yindex]=1;
        queue.add(new int[]{xindex,yindex});
        dfsTraversal(grid,xindex+1,yindex,queue,visited);
        dfsTraversal(grid,xindex-1,yindex,queue,visited);
        dfsTraversal(grid,xindex,yindex+1,queue,visited);
        dfsTraversal(grid,xindex,yindex-1,queue,visited);

    }
    public int bfsTraversal(int[][] grid,Queue<int[]> queue, int[][] visited){
        int[] xcor={-1,1,0,0};
        int[] ycor={0,0,-1,1};
        int level=-1;
        while(queue.size()>0){
            int lengthOfQueue=queue.size();
            level+=1;
            while(lengthOfQueue-->0){
                int[] arr=queue.poll();
                int x=arr[0],y=arr[1];
                for(int i=0;i<4;i++){
                    int xaxis=x+xcor[i];
                    int yaxis=y+ycor[i];
                    if(xaxis<0 || yaxis<0 || xaxis>=grid.length || yaxis>=grid[0].length || visited[xaxis][yaxis]==1)
                        continue;
                    if(grid[xaxis][yaxis]==1) return level;
                    visited[xaxis][yaxis]=1;
                    queue.add(new int[]{xaxis,yaxis});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        shortestBridge obj=new shortestBridge();
        int[][] grid={
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}};
        int flag=0;
        Queue<int[]> queue=new LinkedList();
        int[][] visited=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && flag==0){
                    obj.dfsTraversal(grid,i,j,queue,visited);
                    flag+=1;
                }
                if(flag==1) break;
            }
        }
        System.out.println(obj.bfsTraversal(grid,queue,visited));
    }
}
