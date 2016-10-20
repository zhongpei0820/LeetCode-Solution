// Note: This is an extension of House Robber.

// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Credits:
// Special thanks to @Freezen for adding this problem and creating all test cases.

// Solution : 
// There are two conditions : rob the first house and don't rob the last house ==> [1 to n -1]
// 							  rob the second house and rob the last house ==> [2 to n]
// 	Use DP to compute these two conditions, and return the max of these two results.


public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(robDP(nums,0,nums.length - 2),robDP(nums,1,nums.length - 1));
    }
    
    private int robDP(int[] nums, int low, int high){
        int prev = 0, curr = 0;
        for(int i = low; i <= high; i++){
            int temp = prev;
            prev = curr;
            curr = Math.max(temp + nums[i], prev);
        }
        return curr;
    }
}


// However, the two loops can be converted to one loop:

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int prev0 = 0,curr0 = 0, prev1 = 0, curr1 = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            int temp0 = prev0;
            prev0 = curr0;
            curr0 = Math.max(temp0 + nums[i], prev0);
            int temp1 = prev1;
            prev1 = curr1;
            curr1 = Math.max(temp1 + nums[i + 1], prev1);
        }
        return Math.max(curr1,curr0);
    }
}