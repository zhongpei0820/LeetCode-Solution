// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

//Solution: The idea is similar to bucket sort. Use an array of length 256 to represent all characters.
//			If this String contains repeating characters, the longest substring must be the distance between these two characters.
//			For example: "abcabcbb"  The length is 3, the distance between two 'a'.
// 			First, we initial our bucket with -1, means the position of each character is -1 (not appeared).
//			Then, we start to go through this string. and update the position of each character. (e.g. B[a] = 0, B[b] = 1, B[3] = 2).
//			Use a point p to point at the start of the substring.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] arr = new int[256];
        Arrays.fill(arr,-1);
        int p = -1;
        int maxLength = 0;
        for(int j = 0; j < s.length();j++){
            char c = s.charAt(j);
            if(arr[c] >= p){
                p = arr[c];
            }
            arr[c] = j;
            maxLength = Math.max(maxLength,j-p);
        }
        return maxLength;
    }
}