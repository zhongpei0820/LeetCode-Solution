// Given a string s and a string t, check if s is subsequence of t.

// You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:
// s = "abc", t = "ahbgdc"

// Return true.

// Example 2:
// s = "axc", t = "ahbgdc"

// Return false.


// Solution 1 : Two potiners

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int i = 0, j = 0;
        while(j < t.length() && i < s.length()){
            if(s.charAt(i) == t.charAt(j++)){
                i++;
            }
        }
        return i == s.length();
    }
}

// Solution 2 : Find the first occurence of s.charAt(0) in t[0 ... end], if not found, return false.
// 				If found, find first occurence of s.charAt(1) in t[indexOf(s.charAt(0)) ... end];
// 				So on so forth.

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length()){
            int index = t.indexOf(s.charAt(i), j);
            if(index == -1) return false;
            j = index + 1;
            i++;
        }
        return true;
    }
}
