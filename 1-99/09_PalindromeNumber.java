// Determine whether an integer is a palindrome. Do this without extra space.

// Idea: reverse the integer by mod and division, and compare it with the orginal one. 
//For example, x = 12321. And the reversed integer n = 0 inititaly.
// 12321 % 10 = 1. 12321 / 10 = 1232.  => n = n * 10 + 1 = 1.
//  1232 % 10 = 2.  1232 / 10 =  123.  => n = n * 10 + 2 = 12.
//   123 % 10 = 3.   123 / 10 =   12.  => n = n * 10 + 3 = 123.
//    12 % 10 = 2.    12 / 10 =    1.  => n = n * 10 + 2 = 1232.
//     1 % 10 = 1.     1 / 10 =    0.  => n = n * 10 + 1 = 12321.
// return n == x.
                            
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
