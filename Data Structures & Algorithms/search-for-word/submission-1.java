class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i , int j, String word, int idx) {
        if(idx == word.length()) {
            return true;
        }

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || idx > word.length() || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '.';

        boolean res = dfs(board, i - 1, j, word, idx + 1) ||
            dfs(board, i + 1, j, word, idx + 1) ||
            dfs(board, i, j - 1, word, idx + 1) ||
            dfs(board, i, j + 1, word, idx + 1);

        board[i][j] = temp;

        return res;
    }
}
