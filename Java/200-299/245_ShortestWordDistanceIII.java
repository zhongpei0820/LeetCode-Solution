// This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// word1 and word2 may be the same and they represent two individual words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.

// Note:
// You may assume word1 and word2 are both in the list.

// Solution:

// The same as #243. 
// If word1 == word2, use one index
// If word1 != word2, use two indexes

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1.equals(word2)) return findSame(words,word1);
        else return findNotSame(words,word1,word2);
        
    }
    
    private int findNotSame(String[] words, String word1, String word2){
        int index1 = -words.length, index2 = -words.length;
        int distance = words.length;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
                distance = Math.min(distance, i - index2);
            }else if(words[i].equals(word2)){
                index2 = i;
                distance = Math.min(distance, i - index1);
            }
        }
        return distance;
    }
    
    private int findSame(String[] words, String word){
        int index = -words.length;
        int distance = words.length;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word)){
                distance = Math.min(distance,i - index);
                index = i;
            }
        }
        return distance;
    }
}