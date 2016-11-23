#
#Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
#Each number in C may only be used once in the combination.
#Note:
#
#For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
#A solution set is: 
#[
#  [1, 7],
#  [1, 2, 5],
#  [2, 6],
#  [1, 1, 6]
#]
#

class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ret = []
        self.backTracking(sorted(candidates),0,target,[],ret)
        return ret
        
    def backTracking(self,candidates,start,target,currList,ret):
        if target > 0:
            for i in range(start,len(candidates)):
                if candidates[i] > target : break
                if i > start and candidates[i] == candidates[i - 1] : continue
                self.backTracking(candidates,i + 1,target - candidates[i],currList + [candidates[i]],ret)
        if target == 0:
            ret.append(currList)

        
