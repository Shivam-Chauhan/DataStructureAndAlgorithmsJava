import java.util.ArrayList;
import java.util.List;

    // Time Complexity :- O(N!*N)
    // Space Complexity :- O(N) + Recursion Stack
    // Link :- https://leetcode.com/problems/n-queens/
public class nQueens {
    public boolean isSafe(char[][] board, int row, int col, boolean[] rowArray, boolean[] colArray, boolean[] upperDiagonal, boolean[] lowerDiagonal) {
        return !rowArray[row] && !colArray[col] && !upperDiagonal[row + col] && !lowerDiagonal[board.length - 1 + col - row];
    }

    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public void dfs(char[][] board, int col, List<List<String>> ans, boolean[] rowArray, boolean[] colArray, boolean[] upperDiagonal, boolean[] lowerDiagonal) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col, rowArray, colArray, upperDiagonal, lowerDiagonal)) {
                board[row][col] = 'Q';
                rowArray[row] = true;
                colArray[col] = true;
                upperDiagonal[row + col] = true;
                lowerDiagonal[board.length - 1 + col - row] = true;
                dfs(board, col + 1, ans, rowArray, colArray, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                rowArray[row] = false;
                colArray[col] = false;
                upperDiagonal[row + col] = false;
                lowerDiagonal[board.length - 1 + col - row] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] rowArray = new boolean[n];
        boolean[] colArray = new boolean[n];
        boolean[] upperDiagonal = new boolean[2 * n];
        boolean[] lowerDiagonal = new boolean[2 * n];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(board, 0, ans, rowArray, colArray, upperDiagonal, lowerDiagonal);
        return ans;
    }
}
