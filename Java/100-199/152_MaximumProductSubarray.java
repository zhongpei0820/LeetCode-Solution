// Find the contiguous subarray within an array (containing at least one number) which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.


// Solution 1: DP

// We should keep record of both the current max product and current min product,
// Because min product times a negative number can be the max product.
// Let currMAX = the maximum product including current number, currMIN = the minimal product including current number.
// The notation : currMAX = max{prevMax * nums[i], prevMIN * num[i], nums[i]},
// 				  currMIN = min{prevMin * nums[i], prevMAX * num[i], nums[i]}.
// And maxProduct = max(maxProduct, currMAX).


public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int maxProduct = nums[0];
        int currMAX = nums[0];
        int currMIN = nums[0];
        for(int i = 1; i < nums.length; i++){
            int prevMAX = currMAX, prevMIN = currMIN;
            currMAX = Math.max(Math.max(prevMAX * nums[i], prevMIN * nums[i]), nums[i]);
            currMIN = Math.min(Math.min(prevMAX * nums[i], prevMIN * nums[i]), nums[i]);
            maxProduct = Math.max(currMAX,maxProduct);
        }
        return maxProduct;
    }
}

// Solution 2 : Math

// After solving this problem with DP, one can notices that it is about finding negative numbers.
// If the array contains even neagtive numbers, the result should be the product of the whole array.
// Otherwise, we should rule out one of the nagative integers.
// Notice that if this array contains 0, we should rule out 0 as well.
// First, we iterate the array from left to right, and find the maximum product from num[0] to num[n - 1]. 
// By doing this we can find the maximum product without the rightest negative integers if the number of neageives is odd, or the whole array if even.
// Then, we iterate the array from right to left, and find the maximum product from num[n - 1] to num[0].
// And return the maximum of these two products.

public class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currProduct = 1;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, currProduct *= nums[i]);
            if(nums[i] == 0) currProduct = 1;
        }
        
        currProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            max = Math.max(max, currProduct *= nums[i]);
            if(nums[i] == 0) currProduct = 1;
        }
        
        return max;
    }
}