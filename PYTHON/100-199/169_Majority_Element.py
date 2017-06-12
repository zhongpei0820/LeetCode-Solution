#Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.
#
#You may assume that the array is non-empty and the majority element always exist in the array.
#
#Credits:Special thanks to @ts for adding this problem and creating all test cases.
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ret = 0
        for i in range(0,32):
            mask = 1 << i
            count = 0
            for num in nums:
                if num & mask : count += 1
            if count > len(nums) / 2 : ret |= mask
        return ret if ret < 2 ** 31 else ~ (ret ^ 0xFFFFFFFF)
            