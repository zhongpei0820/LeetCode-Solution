//
//Design a data structure that supports the following two operations:
//void addWord(word)
//bool search(word)
//
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
//For example:addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
//
//Note:
//You may assume that all words are consist of lowercase letters a-z.
//click to show hint.

public class WordDictionary {

    public class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        char value;
        public TrieNode(char c){
            value = c;
        }
    }

    TrieNode root = new TrieNode(' ');

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode(word.charAt(i));
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(word,0,root);
    }

    private boolean searchHelper(String word, int start, TrieNode node){
        if(start == word.length()) return node.isEnd;
        char c = word.charAt(start);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(node.children[i] != null) {
                    if(searchHelper(word,start + 1,node.children[i])){
                        return true;
                    }
                }
            }
        }else {
            return node.children[c - 'a'] != null && searchHelper(word,start + 1,node.children[c - 'a']);
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
