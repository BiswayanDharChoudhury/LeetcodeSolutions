class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean isSafe(char[][] board, int row, int col, char digit) {
        // Check in the same column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }
        // Check in the same row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        // Check in the 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isSafe(board, row, col, digit)) {
                            board[row][col] = digit;
                            if (solveSudokuHelper(board)) {
                                return true;
                            }
                            board[row][col] = '.'; // Backtrack if the current choice leads to an invalid solution
                        }
                    }
                    return false; // No valid choice found, need to backtrack
                }
            }
        }
        return true; // Sudoku solved successfully
    }
}