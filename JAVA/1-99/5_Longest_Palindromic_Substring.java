//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.Example:
//Input: "babad"
//
//Output: "bab"
//
//Note: "aba" is also a valid answer.
//Example:
//Input: "cbbd"
//
//Output: "bb"
//

public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int max_length = 1,max_left = 0;
        for(int start = 0; start < s.length() && s.length() - start > max_length / 2;){
            int left = start, right = start;
            while(right < s.length() - 1 && s.charAt(right) == s.charAt(right+1)) right++;
            start = right + 1;
            while(right < s.length() - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)){
                right++;
                left--;
            }
            if(max_length < right - left + 1){
                max_length = right - left + 1;
                max_left = left;
            }
        }
        return s.substring(max_left,max_left + max_length);
    }
}
