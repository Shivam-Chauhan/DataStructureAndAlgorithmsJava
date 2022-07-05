public class wordSearch {
    // Time Complexity :- O((N*M)^2)
    // Space Complexity :- O(1)
    // Auxillary Space of Recursion Stack
    public boolean wordSearchFunction(char[][] board, String word,int indexX,int indexY,int counter){
        if(counter==word.length()) return true;
        if(indexX<0 || indexY<0 || indexX>=board.length || indexY>=board[0].length || board[indexX][indexY]=='*'
                || board[indexX][indexY]!=word.charAt(counter))
            return false;

        char charStore=board[indexX][indexY];
        board[indexX][indexY]='*';
        boolean answer = wordSearchFunction(board,word,indexX+1,indexY,counter+1) ||
                         wordSearchFunction(board,word,indexX,indexY+1,counter+1) ||
                         wordSearchFunction(board,word,indexX-1,indexY,counter+1) ||
                         wordSearchFunction(board,word,indexX,indexY-1,counter+1);
        board[indexX][indexY]=charStore;
        return answer;

    }
    public static void main(String[] args) {
        wordSearch obj=new wordSearch();
        char[][] board={
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word="DFCE";
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(word.charAt(0) == board[row][col] && obj.wordSearchFunction(board,word,row,col,0)){
                    System.out.println(row+ " "+ col);
                }
            }
        }
    }
}
