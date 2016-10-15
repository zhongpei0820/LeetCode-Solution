// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Solution 1:
// HashSet.

public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])) set.remove(nums[i]);
        }
        return set.iterator().next();
    }
}

// Solution 2:
// Bit Manipulation ^ and its commutativity and Associativity.
// 1 ^ 1 ^ 2 ^3 ^ 3= (1 ^ 1) ^ 2 ^ (3 ^ 3) = 0 ^ 2 ^ 0 = (0 ^ 0) ^ 2 = 0 ^ 2 = 2.

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}