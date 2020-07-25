class Trie {

    /** Initialize your data structure here. */
    class TrieNode
    {
        boolean EndOfWord;
        TrieNode [] child = new TrieNode[26];
    }
    private TrieNode root;
    public Trie() 
    {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode crawl = root;
        for(int i = 0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            if(crawl.child[index]==null)
                crawl.child[index] = new TrieNode();
            crawl = crawl.child[index];
        }
         crawl.EndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode crawl = root;
        for(int i=0;i<word.length();i++)
        {   
            int index = word.charAt(i)-'a';
            if(crawl.child[index]==null)
                return false;
            crawl = crawl.child[index];
        }
        return crawl.EndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        TrieNode crawl = root;
        for(int i = 0;i<prefix.length();i++)
        {
            int index = prefix.charAt(i)-'a';
            if(crawl.child[index]==null)
                return false;
            crawl = crawl.child[index];
        }
        return true;
    }
}
