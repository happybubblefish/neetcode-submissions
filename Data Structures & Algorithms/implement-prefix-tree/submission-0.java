class PrefixTree {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode found = traverse(word);

        return found != null && found.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode found = traverse(prefix);

        return found != null;
    }

    private TrieNode traverse(String str) {
        TrieNode curr = root;

        for(char c : str.toCharArray()) {
            int index = c - 'a';

            if(curr.children[index] == null) {
                return null;
            }

            curr = curr.children[index];
        }

        return curr;
    }
}
