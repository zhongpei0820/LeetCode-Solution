#Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers. Example 1:Input:  k = 3,  n = 7Output: [[1,2,4]]
# Example 2:Input:  k = 3,  n = 9Output: [[1,2,6], [1,3,5], [2,3,4]]
#Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.

import math
class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        ret = []
        self.backTracking(k,n,1,[],ret)
        return ret
        
    def backTracking(self,k,n,start,currList,ret):
        if n > 9 * k or k > n: return
        if n == 0 and k == 0:
            ret.append(currList)
            return
        if n > 0 and k > 0:
            for i in range(start,min(10,n / k + 1)):
                self.backTracking(k - 1,n - i,i + 1,currList + [i],ret)
