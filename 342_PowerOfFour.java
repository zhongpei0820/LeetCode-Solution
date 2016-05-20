// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

// Example:
// Given num = 16, return true. Given num = 5, return false.

// Follow up: Could you solve it without loops/recursion?


//Idea: A simple solution is use log function in JAVA.

public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        double result = Math.log((double)num)/Math.log(4);
        return result == Math.floor(result);
    }
}
