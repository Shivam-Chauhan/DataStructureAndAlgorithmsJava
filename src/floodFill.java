import java.util.LinkedList;
import java.util.Queue;

public class floodFill {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(N*M)
    public void floodFillImplementationFunction(int[][] image,int xaxis,int yaxis, int color, int colorPixel){
        int [] xCorrdinate={0,-1,0,1};
        int [] yCorrdinate={-1,0,1,0};
        int[][] visited=new int[image.length][image[0].length];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{xaxis,yaxis});
        image[xaxis][yaxis]=color;
        visited[xaxis][yaxis]=1;
        while(queue.size()>0){
            int[] tempStore=queue.poll();
            int xcor=tempStore[0],ycor=tempStore[1];
            for(int i=0;i<4;i++){
                int xcors=xcor+xCorrdinate[i];
                int ycors=ycor+yCorrdinate[i];
                if(xcors>=0 && xcors<image.length && ycors>=0 && ycors<image[0].length && visited[xcors][ycors]==0
                        && image[xcors][ycors]==colorPixel){
                    queue.add(new int[]{xcors,ycors});
                    image[xcors][ycors]=color;
                    visited[xcors][ycors]=1;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] image={
                {1,1,1},
                {1,1,0},
                {1,0,1}};
        int sr=1,sc=1,color=2;
        floodFill obj=new floodFill();
        obj.floodFillImplementationFunction(image,sr,sc,color,image[sr][sc]);
    }
}
