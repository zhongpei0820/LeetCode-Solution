// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

// Example:
// Given nums = [-2, 0, 3, -5, 2, -1]

// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// Note:
// You may assume that the array does not change.
// There are many calls to sumRange function.


//Solution:
// From the observation, sumRange(m,n) = sum(0,n) - sum(0, m - 1).
// Because there are many calls to sumRange function, we can cache the sum(0,k) in an array.
// Sum[k] means the sum of the first k elements in the orignal array, thus sum[0] = 0, sum[n] = sum of all elements.
// So, sumRange(i,j) = sum[j + 1] - sum[i].

public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] + nums[i];    
        }
    }
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}