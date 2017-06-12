#
#Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
#
#
#For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
#the contiguous subarray [4,-1,2,1] has the largest sum = 6.
#
#
#click to show more practice.
#
#More practice:
#
#If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
#
import sys
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        currSum = 0
        maxSum = -sys.maxint
        # startIndex = endIndex = 0
        for i in range(0,len(nums)):
            if currSum + nums[i] <= nums[i]:
                currSum = nums[i]
                # startIndex = endIndex = i
            else:
                currSum += nums[i]
            if currSum > maxSum: maxSum = currSum
            # print currSum,maxSum
            # endIndex = i
        # return nums[startIndex:endIndex]
        return maxSum