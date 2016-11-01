
// Given an integer, write a function to determine if it is a power of two.

//Idea: An integer n is power of two iff n & (n-1) == 0. 
//For example: 16 -> 10000, 16 - 1 = 01111, 10000 & 01111 = 00000.  

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        return (0 == (n & (n-1)));
    }
}
