// Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int currentLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s,i - currentLength - 1, i)){
                res = s.substring(i - currentLength - 1, i + 1);
                currentLength = currentLength + 2;
            }else if(isPalindrome(s,i - currentLength, i)){
                res = s.substring(i - currentLength, i + 1);
                currentLength = currentLength + 1;
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String s, int start,int end){
        if(start < 0) return false;
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}