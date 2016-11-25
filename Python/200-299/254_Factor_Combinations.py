#Numbers can be regarded as product of its factors. For example,  8 = 2 x 2 x 2;
#  = 2 x 4.
#Write a function that takes an integer n and return all possible combinations of its factors. 
#Note: 
#Examples: 
# input: 1
# output: 
#[]
#[]
#[
#  [2, 6],
#  [2, 2, 3],
#  [3, 4]
#]
#[
#  [2, 16],
#  [2, 2, 8],
#  [2, 2, 2, 4],
#  [2, 2, 2, 2, 2],
#  [2, 4, 4],
#  [4, 8]
#]
#

class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        ret = []
        self.backTracking(n,2,[],ret)
        return ret
        
        
    def backTracking(self,n,start,curr,ret):
        i = start
        while i ** 2 <= n:
            if n % i == 0:
                ret.append(curr + [i,n / i])
                self.backTracking(n / i,i,curr + [i],ret)
            i += 1
