#The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
#
#Given two integers x and y, calculate the Hamming distance.
#
#Note:
#0 &le; x, y &lt; 231.
#
#
#Example:
#
#Input: x = 1, y = 4
#
#Output: 2
#
#Explanation:
#1   (0 0 0 1)
#4   (0 1 0 0)
#       ↑   ↑
#
#The above arrows point to positions where the corresponding bits are different.
#
#
class Solution(object):
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        xor = x^y
        ret = 0
        while xor:
            if xor & 1 == 1: ret += 1
            xor >>= 1
        return ret