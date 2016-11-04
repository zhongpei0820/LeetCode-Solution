# Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

# Note: You may not slant the container.

# Solution:
# Starting from both sides, left and right, compute the area between left and right.
# Then move left and right to find a possible larger area.
# a possible larger area must have higher lines than the previous area.
# So we find the new left and right which are greater than min(left,right)

class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        left,right,maxArea = 0,len(height) - 1,0
        while left < right :
            h =  min(height[left],height[right]);
            maxArea = max(maxArea, (right - left) * h);
            while left < right and height[left] <= h:
                left += 1
            while left < right and height[right] <= h:
                right -= 1
        return maxArea