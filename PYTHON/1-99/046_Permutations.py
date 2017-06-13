#
#Given a collection of distinct numbers, return all possible permutations.
#
#
#
#For example,
#[1,2,3] have the following permutations:
#
#[
#  [1,2,3],
#  [1,3,2],
#  [2,1,3],
#  [2,3,1],
#  [3,1,2],
#  [3,2,1]
#]
#
#

import copy
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = []
        self.backTracing(nums,0,[],ret)
        return ret
    
    def backTracing(self,nums,index,tempList,ret):
        if index == len(nums):
            ret.append(tempList)
            return
        for i in range(0,len(tempList) + 1):
            cp = copy.deepcopy(tempList)
            cp.insert(i,nums[index])
            self.backTracing(nums,index + 1,cp,ret)
            
            
        