#
#Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
#
#If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
#
#The replacement must be in-place, do not allocate extra memory.
#
#Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
#1,2,3 → 1,3,2
#3,2,1 → 1,2,3
#1,1,5 → 1,5,1
#

class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        k = -1
        for i in range(len(nums) - 2,-1,-1):
            if nums[i] < nums[i + 1] :
                k = i
                break
        if k == -1:
            nums = self.reverse(0,len(nums) - 1,nums)
            return
        l = -1
        for i in range(len(nums) - 1,k,-1):
            if nums[i] > nums[k]:
                l = i
                break
        nums[k],nums[l] = nums[l],nums[k]
        self.reverse(k+1,len(nums) - 1,nums)
        return
        
    def reverse(self,start,end,nums):
        while start < end:
            nums[start],nums[end] = nums[end],nums[start]
            start += 1
            end -= 1
