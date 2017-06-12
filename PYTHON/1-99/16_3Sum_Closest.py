# Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

#     For example, given array S = {-1 2 1 -4}, and target = 1.

#     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


# Solution:
import sys
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums = sorted(nums)
        low,high = 0, len(nums) - 1
        res = sys.maxint
        min_diff = sys.maxint
        for i in range(0,len(nums) - 2):
            low,high = i + 1,len(nums) - 1
            diff = sys.maxint
            while(low < high):
                s = nums[i] + nums[low] + nums[high]
                if s < target:
                    low += 1
                elif s > target:
                    high -= 1
                else:
                    return s
                diff = abs(s - target)
                if diff < min_diff:
                    min_diff = diff
                    res = s
        return res