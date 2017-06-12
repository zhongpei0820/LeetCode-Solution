#
#Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
#
#
#
#Note:
#Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
#
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        for i in range(0,32):
            counter = 0
            for num in nums:
                if num & 1 << i : counter += 1
            ret |= (counter % 3) << i
        return ret if ret < 2 ** 31 else ret - 2 ** 32