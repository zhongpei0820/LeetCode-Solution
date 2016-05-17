// Given two strings s and t, write a function to determine if t is an anagram of s.
// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

//Idea: sort two String usign java.util.Arrays.sort(), compare the sorted Strings. The time complexity is O(nlogn)

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        
        String s1 = String.valueOf(c1);
        String s2 = String.valueOf(c2);
        
        return s1.equals(s2);
    }
}
