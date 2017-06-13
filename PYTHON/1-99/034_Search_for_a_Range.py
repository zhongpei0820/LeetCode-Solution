#Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
#
#Your algorithm's runtime complexity must be in the order of O(log n).
#
#If the target is not found in the array, return [-1, -1].
#
#
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
        return self.search(0,len(nums) - 1,nums,target)
        
    
    def search(self,start,end,nums,target):
        if nums[start] == target == nums[end]:
            return [start,end]
        if nums[start] <= target <= nums[end]:
            mid = start + (end - start) / 2
            lo = self.search(start,mid,nums,target)
            hi = self.search(mid + 1,end,nums,target)
            if lo == [-1,-1] : return hi
            if hi == [-1,-1] : return lo
            return [lo[0],hi[1]]
        return [-1,-1]