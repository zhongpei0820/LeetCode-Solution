#
#Given a set of distinct integers, nums, return all possible subsets.
#
#Note: The solution set must not contain duplicate subsets.
#
#
#For example,
#If nums = [1,2,3], a solution is:
#
#
#
#[
#  [3],
#  [1],
#  [2],
#  [1,2,3],
#  [1,3],
#  [2,3],
#  [1,2],
#  []
#]
#

class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = []
        total = 1 << len(nums)
        for i in range(0,total):
            tmp = []
            for j in range(0,len(nums)):
                if 1 & (i >> j) == 1 : tmp.append(nums[j])
            ret.append(tmp)
        return ret