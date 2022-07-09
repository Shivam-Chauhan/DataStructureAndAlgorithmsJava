public class surrondedRegions {
    public void dfsTraversal(char[][] boards,int xindex, int yindex){
        if(xindex<0 || xindex>=boards.length || yindex<0 || yindex>=boards[0].length || boards[xindex][yindex]!='O') return;

        boards[xindex][yindex]='#';
        dfsTraversal(boards,xindex+1,yindex);
        dfsTraversal(boards,xindex-1,yindex);
        dfsTraversal(boards,xindex,yindex+1);
        dfsTraversal(boards,xindex,yindex-1);
    }
    public static void main(String[] args) {
        surrondedRegions obj= new surrondedRegions();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        for(int row=0;row<board.length;row++){
            if(board[row][0]=='O') obj.dfsTraversal(board,row,0);
            if(board[row][board[0].length-1]=='O') obj.dfsTraversal(board,row, board[0].length-1);
        }
        for(int col=0;col< board[0].length;col++){
            if(board[0][col]=='O') obj.dfsTraversal(board,0,col);
            if(board[board.length-1][col]=='O') obj.dfsTraversal(board, board.length-1, col);
        }
        for(int row=0;row<board.length;row++){
            for(int col=0;col< board[0].length;col++){
                if(board[row][col]=='#') board[row][col]='O';
                else if(board[row][col]=='O') board[row][col]='X';
            }
        }


    }
}

