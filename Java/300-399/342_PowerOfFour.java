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

//Another solution is bit manipulation.
//If the number is power of 4, it must be power of 2. 
//Moreover, (num & 0x55555555) == num

public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        return ((num & 0x55555555) == num) && ((num & (num -1)) == 0);
    }
}
