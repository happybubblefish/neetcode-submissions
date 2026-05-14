class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        for(String word : words) {
            TrieNode curr = root;

            for(char c : word.toCharArray()) {
                int index = c - 'a';

                if(curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }

            curr.word = word;
        }

        int rows = board.length, cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];

        if(c == '#') {
            return;
        }

        TrieNode next = node.children[c - 'a'];

        if(next == null) {
            return;
        }

        if(next.word != null) {
            res.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';

        dfs(board, i - 1, j, next, res);
        dfs(board, i + 1, j, next, res);
        dfs(board, i, j - 1, next, res);
        dfs(board, i, j + 1, next, res);

        board[i][j] = c;
    }
}
