class PrefixTree {

    class TrieNode {
        TrieNode[] children;
        boolean isDone;

        public TrieNode() {
            children = new TrieNode[26];
            isDone = false;
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

        curr.isDone = true;
    }

    public boolean search(String word) {
        TrieNode found = traverse(word);

        return found != null && found.isDone;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            int index = c - 'a';

            if(curr.children[index] == null) {
                return null;
            }

            curr = curr.children[index];
        }

        return curr;
    }
}
