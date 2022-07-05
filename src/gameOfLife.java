public class gameOfLife {
    // Time Complexity :- O(N*M)
    // Space Complexity :- O(1)
    public int liveNeighbourCount(int [][] board,int xaxis,int yaxis,int rowLength,int colLength){
        int[] xcor={-1,-1,-1,0,0,1,1,1};
        int[] ycor={-1,0,1,-1,1,-1,0,1};
        int counter=0;
        for(int i=0;i<8;i++){
            int x=xaxis+xcor[i];
            int y=yaxis+ycor[i];
            if(x>=0 && x<rowLength && y>=0 && y<colLength && (board[x][y]==1 || board[x][y]==3)) counter++;
        }
        return counter;

    }
    public static void main(String[] args) {
        gameOfLife obj=new gameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};

        int numRows=board.length,numCols=board[0].length;
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                int liveNeigh=obj.liveNeighbourCount(board,i,j,numRows,numCols);
                if(board[i][j]==0){
                    if(liveNeigh==3) board[i][j]=2; // NEWLY Alive Cell
                }
                else if(board[i][j]==1){
                    if(liveNeigh<2 || liveNeigh>3) board[i][j]=3; // NEWLY DEAD CELL
                }
            }
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(board[i][j]==2) board[i][j]=1;
                else if(board[i][j]==3) board[i][j]=0;
            }
        }
    }

}
