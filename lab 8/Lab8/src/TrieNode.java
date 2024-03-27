// Sourced from: https://www.geeksforgeeks.org/trie-insert-and-search/
// Code written by: Sumit Ghosh

class TrieNode
{
    TrieNode[] children = new TrieNode[255];
    // isEndOfWord is true if the node
    // represents end of a word
    boolean isEndOfWord;
}
