// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

// The order of output does not matter.

// Example 1:

// Input:
// s: "cbaebabacd" p: "abc"

// Output:
// [0, 6]

// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input:
// s: "abab" p: "ab"

// Output:
// [0, 1, 2]

// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

// Solution: Sliding Window
// We can solve this problem using a hash map and two pointers as the sliding window.
// The values in the hash represents the number of each characters in p.
// And we use left and right to suggest the silding window.

//move right everytime, if the character exists in p's hash, decrease the count
//current hash value >= 1 means the character is existing in p
//when the count is down to 0, means we found the right anagram
//then add window's left to result list

 //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
 //++ to reset the hash because we kicked out the left
 //only increase the count if the character is in p
 //the count >= 0 indicate it was original in the hash, cuz it won't go below 0

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        int[] hash = new int[26];
        for(int i = 0; i < p.length(); i++){
            hash[p.charAt(i) - 'a']++;
        }
        int count = p.length();
        for(int left = 0, right = 0; right < s.length();right++){
            hash[s.charAt(right) - 'a']--;
            if(hash[s.charAt(right) - 'a'] >= 0) count--;
            if(count == 0) list.add(left);
            if(right - left == p.length() - 1){
                hash[s.charAt(left) - 'a']++;
                if(hash[s.charAt(left) - 'a'] >= 1) count++;
                left++;
            }
        }
        return list;
    }
}