// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

// click to show spoilers.

// Have you thought about this?
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

// Solution:
// Reverse Integer is easy: each digit in res = x % 10, x /= 10, res = res*10 + x % 10.
// The important part is to avoid overflow. 
// First we observe that if x is positive, overflow happens if res * 10 + x % 10 > Integer.MAX_VALUE.
// So, if x > 0, && res > (Integer.MAX_VALUE - x % 10) / 10, return 0.
// The same for negative, overflow happens if res * 10 + x % 10 < Integer.MIN_VALUE.
// So, if x < 0, && res < (Integer.MIN_VALUE - x % 10) / 10, return 0.

public class Solution {
    public int reverse(int x) {
        int ret = 0;
        while(x != 0){
            int remain = x % 10;
            if(x > 0 && ret > (Integer.MAX_VALUE - remain) / 10) return 0;
            if(x < 0 && ret < (Integer.MIN_VALUE - remain) / 10) return 0;
            ret = ret * 10 + remain;
            x /= 10;
        }
        return ret;
    }
}