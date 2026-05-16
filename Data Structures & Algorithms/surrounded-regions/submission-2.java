class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            dfs(board, r, 0);
            dfs(board, r, cols - 1);
        }

        for(int c = 0; c < cols; c++) {
            dfs(board, 0, c);
            dfs(board, rows - 1, c);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    int[][] dirs = {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
    };

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if(board[i][j] != 'O') {
            return;
        }
        
        if(board[i][j] == 'O') {
            board[i][j] = 'B';
        }

        for(int[] d : dirs) {
            dfs(board, i + d[0], j + d[1]);
        }
    }
}
