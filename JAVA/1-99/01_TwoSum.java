// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution.

// Example:
// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
// UPDATE (2016/2/13):
// The return format had been changed to zero-based indices. Please read the above updated description carefully.

// Solution:
// Because each input would have exactly one solution, we can use hash map for this problem.
// iterate the array, and put (target - nums[i], nums[i]) as the (key,value) pair into the hash map.
// if nums[i] is contained in the map, then we find the two numbers.

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])) map.put(target-nums[i],i);
            else{
                int[] result = {map.get(nums[i]),i};
                return result;
            }
        }
        return nums;
    }
}