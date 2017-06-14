// Given an array and a value, remove all instances of that value in place and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

// Example:
// Given input array nums = [3,2,2,3], val = 3

// Your function should return length = 2, with the first two elements of nums being 2.

//Idea: Traverse the array with two pointers:i ,j, which traverse from the beginning and the end respectively.
//      1. If nums[i] == val, swap nums[i] and nums[j], j--. If the new nums[i] may still equal to val, repeat 1. 
//      2. i++
//      3. If i <= j; repeat 1.

public class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0,p2 = nums.length - 1;
        int result = 0;
        while(p1 <= p2){
            if(nums[p1] == val){
                nums[p1] = nums[p2--];
                result++;
                continue;
            }
            p1++;
        }
        result = nums.length - result;
        return result;
    }
}
