// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

// Solution:

// Use two indexes to store the positions of word1 and word2.
// if(words[i] == word1) index1 = i
// if(words[i] == word2) index2 = i
// distance = min(distance, abs(index1 - index2))

// However, the distance should only be updated when we find a new word1 or word2.
// if(word[i] == word1){
// 		index1 = i,
// 		distance = min(distance, i - index2)
// }
// The same goes for word2

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
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
}