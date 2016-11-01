// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// For example,
// Given nums = [0, 1, 3] return 2.

// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

// Solution 1 :
// XOR

// The nums is 0 to n missing a certain number.
// The whole array length should be n + 1.

public class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i]^i;
        }
        return res;
    }
}


// Solutuon 2:
// Sum
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        return (0 + n) * (n + 1) / 2 - sum;
    }
}