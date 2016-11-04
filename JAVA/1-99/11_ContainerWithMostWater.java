// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container.

// Solution:
// Intuition: Solve this with two pointers, left and right.
// while left < right : 
//        maxArea = max(maxArea, (right - left) * Math.min(height[left],height[right]))
//        if height[left] < height[right]: left++
//        else: right++

// // # Solution:
// # Starting from both sides, left and right, compute the area between left and right.
// # Then move left and right to find a possible larger area.
// # a possible larger area must have higher lines than the previous area.
// # So we find the new left and right which are greater than min(left,right)

// Proof:
// if we have a1,a2,a3 ... a20, and the max area is between a10 and a15.
// If the left pointer is pointing at a10, how can we be sure the right pointer can be moved to a15 while the left is pointint at a10.
// Say now the right is pointing at a16. Then we compare a15 and a11, if a10 < a16, we will move the left to a11.
// However, this is impossible, because if a10 < a16, then the area between a10 and a15 must be smaller than a10 and a16, which is 
// against that a10 and a15 is the biggest area.
// So a10 must be greater than a16, and the next move will be a16 to a15.
// Therefore, we can find the maximum area.

public class Solution {
    public int maxArea(int[] height) {
        int left = 0,right = height.length - 1,max = 0;
        while(left < right){
            int h = Math.min(height[left],height[right]);
            max = Math.max(max,(right - left) * h);
            while(height[left] <= h && left < right) left++;
            while(height[right] <= h && left < right) right--;
        }
        return max;
    }
}