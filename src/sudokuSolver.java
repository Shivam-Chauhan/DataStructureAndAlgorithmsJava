public class sudokuSolver {
    // Time Complexity :- O(N!)
    // Space Complexity :- O(1) + Recursion Stack
    // Link :- https://leetcode.com/problems/sudoku-solver/
    public boolean isValid(char[][] board, char ch, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch) return false;
            if (board[row][i] == ch) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) return false;
        }
        return true;
    }

    public boolean sudokuSolver(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, ch, row, col)) {
                            board[row][col] = ch;
                            if (sudokuSolver(board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;

                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        sudokuSolver(board);
    }
}
