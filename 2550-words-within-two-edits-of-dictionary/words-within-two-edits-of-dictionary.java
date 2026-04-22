class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    class Trie {
        private TrieNode root;
        
        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                insert(word);
            }
        }
        
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        
        public TrieNode getRoot() {
            return root;
        }
    }
    
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        
        Trie trie = new Trie(dictionary);
        TrieNode root = trie.getRoot();
        
        for (String query : queries) {
            if (dfs(root, query, 0, 0)) {
                res.add(query);
            }
        }
        
        return res;
    }
    
    private boolean dfs(TrieNode node, String query, int pos, int editsUsed) {
        if (editsUsed > 2) {
            return false;
        }
        
        if (pos == query.length()) {
            return node.isEnd;
        }
        
        char currChar = query.charAt(pos);
        int index = currChar - 'a';
        
        if (node.children[index] != null) {
            if (dfs(node.children[index], query, pos + 1, editsUsed)) {
                return true;
            }
        }
       
        for (int i = 0; i < 26; i++) {
            if (i != index && node.children[i] != null) {
                if (dfs(node.children[i], query, pos + 1, editsUsed + 1)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}