class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        for(int i = 0; i < 9; i++) {
            if(!rowCheck(board, i)) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(!colCheck(board, i)) {
                return false;
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!squareCheck(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean rowCheck(char[][] board, int row) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            if(board[row][i] != '.' && !set.add(board[row][i] - '0')) {
                return false;
            }
        }

        return true;
    }

    private boolean colCheck(char[][] board, int col) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && !set.add(board[i][col] - '0')) {
                return false;
            }
        }

        return true;
    }

    private boolean squareCheck(char[][] board, int row, int col) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[row * 3 + i][col * 3 + j] != '.' && !set.add(board[row * 3 + i][col * 3 + j] - '0')) {
                    return false;
                }
            }
        }

        return true;
    }
}
