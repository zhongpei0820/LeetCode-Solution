#
#Given a collection of numbers that might contain duplicates, return all possible unique permutations.
#
#
#
#For example,
#[1,1,2] have the following unique permutations:
#
#[
#  [1,1,2],
#  [1,2,1],
#  [2,1,1]
#]
#
#
class Solution(object):
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = []
        sorted(nums)
        self.backTracking(nums,0,[],ret)
        return ret
        
    def backTracking(self,nums,index,currList,ret):
        if index == len(nums):
            ret.append(currList)
            return
        for i in range(0,len(currList) + 1):
            self.backTracking(nums,index + 1,currList[:i] + [nums[index]] + currList[i:],ret)
            if i < len(currList) and currList[i] == nums[index] : break;