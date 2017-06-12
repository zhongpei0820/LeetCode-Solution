#Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 &le; ai < 231.
#
#Find the maximum result of ai XOR aj, where 0 &le; i, j &lt; n.
#
#Could you do this in O(n) runtime?
#
#Example:
#
#Input: [3, 10, 5, 25, 2, 8]
#
#Output: 28
#
#Explanation: The maximum result is 5 ^ 25 = 28.
#
#
class Solution(object):
    def findMaximumXOR(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = mask = 0
        for i in range(31,-1,-1):
            mask = mask | 1 << i
            hashset = set()
            for num in nums:
                hashset.add(num & mask)
            candidate = ret | 1 << i
            for ele in hashset:
                if candidate ^ ele in hashset : ret = candidate
        return ret