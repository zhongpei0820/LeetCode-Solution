#
#Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
#
#
#The same repeated number may be chosen from C unlimited number of times.
#
#
#Note:
#
#All numbers (including target) will be positive integers.
#The solution set must not contain duplicate combinations.
#
#
#
#
#For example, given candidate set [2, 3, 6, 7] and target 7, 
#A solution set is: 
#
#[
#  [7],
#  [2, 2, 3]
#]
#
#

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ret = []
        self.backTracking(sorted(candidates),0,target,[],ret)
        return ret
        
    def backTracking(self, candidates, start,target, current,ret):
        if target < 0 : return
        if target == 0:
            ret.append(current)
            return
        for i in range(start,len(candidates)):
            if candidates[i] > target : break
            self.backTracking(candidates,i,target - candidates[i],current + [candidates[i]],ret)