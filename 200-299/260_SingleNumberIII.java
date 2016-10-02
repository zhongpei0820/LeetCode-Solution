// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// For example:

// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

//Idea: Bit Manipulation : xor.
//      a^a = 0, a^0 = a, a^b = b^a
//      Given nums = [a,b,c,d,a,b]. 
//      int xor = a^b^c^d^a^b = a^a^b^b^c^d = c^d
//      int flag = xor & ~(xor - 1).
//      xor & ~(xor - 1) returns the first 1 in xor.
//      And 1 in xor means that bit is different in c and d.
//      Say c = 1001, d = 1111. xor = c^d = 0110. 
//      flag = xor & ~(xor - 1) = 0110 & ~(0101) = (0110) & (1010) = 0010
//      we can divide the numbers into two groups using the flag, one contains c and the other contains d.

public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        res[0] = 0;
        res[1] = 0;
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        int flag = xor & ~(xor - 1);
        for(int num : nums){
            if((num & flag) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
       return res;
    }
}
