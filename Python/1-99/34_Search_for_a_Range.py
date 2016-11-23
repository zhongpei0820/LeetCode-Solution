#Given a sorted array of integers, find the starting and ending position of a given target value.Your algorithm's runtime complexity must be in the order of O(log n).If the target is not found in the array, return [-1, -1].
#For example,
#Given [5, 7, 7, 8, 8, 10] and target value 8,
#return [3, 4].
#

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        lo = self.binarySearch(0,len(nums) - 1,target,nums)
        if nums[lo] != target : return [-1,-1]
        hi = self.binarySearch(0,len(nums) - 1,target + 1,nums)
        if nums[hi] == target : return [lo,hi]
        return [lo,hi - 1]
        
        
    def binarySearch(self,start,end,target,nums):
        while start < end:
            mid = start + (end - start) / 2
            if nums[mid] >= target : end = mid
            else : start = mid + 1
        return start
