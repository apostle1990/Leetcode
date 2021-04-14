package chapter11;

public class TrieNode {
    public TrieNode[] chileren;
    boolean isleaf;

    public TrieNode(){
        chileren = new TrieNode[26];
        isleaf = false;
    }
}
