// Determine whether an integer is a palindrome. Do this without extra space.

// Idea: reverse the integer and compare it with the orginal one. 

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int mir = 0;
        while(num > 0){
            mir = 10* mir + num % 10;
            num /= 10;
        }
    return mir == x;
    }
}
