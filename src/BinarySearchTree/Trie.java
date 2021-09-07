package BinarySearchTree;

//前缀树实现
public class Trie {
    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode T = root;
        char[] ch = word.toCharArray();
        for (char c:ch){
            int a = c - 'a';
            if (T.chileren[a] == null){
                T.chileren[a] = new TrieNode();
            }
            T = T.chileren[a];
        }
        T.isleaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode T = root;
        char[] ch = word.toCharArray();
        for (char c:ch){
            int a = c - 'a';
            if (T.chileren[a] ==null) return false;
            T = T.chileren[a];
        }
        return T.isleaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode T = root;
        char[] ch = prefix.toCharArray();
        for (char c:ch){
            int a = c - 'a';
            if (T.chileren[a] ==null) return false;
            T = T.chileren[a];
        }
        return true;
    }
}
