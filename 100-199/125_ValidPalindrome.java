// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.

// Solution:
// Obivously, we can use two pointers strating from 0 and s.length() - 1 respectively.
// Since considering only aplpanumeric characters, and ignoring cases. First convert the string to lower case.
// Then, when the pointer is pointing at a non-aplphnumeric charcter, just skip it.


public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while(low < high){
            while(!isAlphanumeric(s.charAt(low)) && low < high) low++;
            while(!isAlphanumeric(s.charAt(high)) && low < high) high--;
            if(s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c){
        if(c >= 'a' && c <='z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
}