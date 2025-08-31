class TrieNode {
    TrieNode[] children;
    boolean isLeaf;

    TrieNode()
    {
        children = new TrieNode[26];
        isLeaf = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() { 
        root = new TrieNode(); 
        
    }

    // Method to insert a key into the Trie
    public void insert(String key)
    {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
    }

    // Method to search a key in the Trie
    public boolean search(String key)
    {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isLeaf;
    }

    // Method to check if a prefix exists in the Trie
    public boolean isPrefix(String prefix)
    {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args)
    {
        Trie trie = new Trie();
        String[] arr
            = {"and", "ant", "do", "dad"};
        for (String s : arr) {
            trie.insert(s);
        }
        String[] searchKeys = { "do", "gee", "bat" };
        for (String s : searchKeys) {
            if (trie.search(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
        System.out.println();
        String[] prefixKeys = { "ge", "ba", "do", "de" };
        for (String s : prefixKeys) {
            if (trie.isPrefix(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
}
