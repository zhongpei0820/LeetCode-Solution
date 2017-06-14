#
#Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
#
#
#
#For example, 
#Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
#
#
#
#
#The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) == 0 : return 0
        maxVal = max(height)
        maxIndex = height.index(maxVal)
        height[maxIndex] += 1
        def helper(height) : 
            left,vol = 0,0
            while left < len(height) : 
                while left < len(height) and height[left] == 0 : left += 1
                right,devol = left + 1,0
                while right < len(height) and height[left] > height[right]:
                    devol += height[right]
                    right += 1
                if right < len(height):
                    vol += (right - left - 1) * height[left] - devol
                    left = right
                else : break
            return vol
        return helper(height) + helper(height[::-1])
