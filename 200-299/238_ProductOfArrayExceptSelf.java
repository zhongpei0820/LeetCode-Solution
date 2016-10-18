// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

// Solution:
// Let res[i] represent nums[0] * ... * nums[i - 1].
// Let res[0] = 1.
// so, res[1] = res[0] * nums[0] = 1 * nums[0] = nums[0].
// 	   res[2] = res[1] * nums[1] = nums[0] * nums[1]..
//     So on so forth.
// Now each element in res is the product from nums[0] to nums[i - 1].
// Then, we let res[i] = res[i] * nums[0], and res[0] = res[0] * nums[i].
// By doing this we upadte res[0] = res[i] * res[i - 1] * res[i - 2]...
// and res[i] = res[0] * res[1] * res[2] * ... * res[i - 1].
// Som res[i] * res[0] = the product of the array except i.

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = nums[i - 1] * result[i - 1];
        }
        
        for(int j = nums.length - 1; j > 0; j--){
            result[j] *= result[0];
            result[0] *= nums[j];
        }
        return result;
    }
}