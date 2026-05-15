class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        for(int i = 0; i < cols; i++) {
            dfs(board, 0, i);
            dfs(board, rows - 1, i);
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
            int r = i + d[0];
            int c = j + d[1];

            dfs(board, r, c);
        }
    }
}
