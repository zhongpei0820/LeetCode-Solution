// This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

// Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.

// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

// Solution:
// Because we have to call the method time and time again, instead of finding the positions of each words when calling the methods,
// We can simply record the occurence of each word when initializing our class.
// Use a hash table to store the word and its positions in the array.
// In the method function, we can get the positions of the two words, and compare their positions.
// Because their positions are already in a sorted way, we can compare them like the way used in merge sort.

public class WordDistance {

    HashMap<String,List<Integer>> map;
    
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i],list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        for(int i = 0,j = 0; i < list1.size() && j < list2.size();){
            if(list1.get(i) > list2.get(j)){
                distance = Math.min(distance, list1.get(i) - list2.get(j));
                j++;
            }else{
                distance = Math.min(distance, list2.get(j) - list1.get(i));
                i++;
            }
        }
        return distance;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");