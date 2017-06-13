#
#Find the contiguous subarray within an array (containing at least one number) which has the largest product.
#
#
#
#For example, given the array [2,3,-2,4],
#the contiguous subarray [2,3] has the largest product = 6.
#

class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0 : return 0
        currMax = nums[0]
        currMin = nums[0]
        preMax = nums[0]
        preMin = nums[0]
        ret = currMax
        for i in range(1,len(nums)):
            currMax = max(max(preMax * nums[i],preMin * nums[i]),nums[i])
            currMin = min(min(preMax * nums[i],preMin * nums[i]),nums[i])
            ret = max(ret,currMax)
            preMax = currMax
            preMin = currMin
        return ret
            