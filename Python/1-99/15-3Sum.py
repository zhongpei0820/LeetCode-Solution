# Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

# Note: The solution set must not contain duplicate triplets.

# For example, given array S = [-1, 0, 1, 2, -1, -4],

# A solution set is:
# [
#   [-1, 0, 1],
#   [-1, -1, 2]
# 

class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        ret = []
        for i in range(0,len(nums) - 2):
            if nums[i] > 0:
                break
            if i != 0 and nums[i] == nums[i - 1]:
                continue
            low,high = i + 1, len(nums) - 1
            while low < high:
                sum = nums[i] + nums[low] + nums[high]
                if sum == 0:
                    ret.append([nums[i],nums[low],nums[high]])
                if sum <= 0:
                    while low < high and nums[low] == nums[low + 1]:
                        low += 1
                    low += 1
                if sum >= 0:
                    while low < high and nums[high] == nums[high - 1]:
                        high -= 1
                    high -= 1
        return ret