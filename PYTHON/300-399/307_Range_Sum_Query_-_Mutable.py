#Given an integer array nums, find the sum of the elements between indices i and j (i &le; j), inclusive.
#
#The update(i, val) function modifies nums by updating the element at index i to val.
#
#Example:
#
#Given nums = [1, 3, 5]
#
#sumRange(0, 2) -> 9
#update(1, 2)
#sumRange(0, 2) -> 8
#
#
#
#Note:
#
#The array is only modifiable by the update function.
#You may assume the number of calls to update and sumRange function is distributed evenly.
#
#

class NumArray(object):
    def __init__(self, nums):
        """
        initialize your data structure here.
        :type nums: List[int]
        """
        self.nums = nums
        self.nodes = [0 if i == 0 else sum(nums[i - self.lowBit(i) : i]) for i in range(0,len(nums) + 1)]
        self.n = len(self.nodes)

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: int
        """
        diff,self.nums[i] = val - self.nums[i],val
        i += 1
        while i < self.n:
            self.nodes[i] += diff
            i += self.lowBit(i)
        
    def sumRange(self, i, j):
        """
        sum of elements nums[i..j], inclusive.
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.sumPrefix(j + 1) - self.sumPrefix(i)
        
    def sumPrefix(self,i):
        sum = 0
        while i > 0:
            sum += self.nodes[i]
            i -= self.lowBit(i)
        return sum
            
    def lowBit(self,n):
        return n & -n


# Your NumArray object will be instantiated and called as such:
# numArray = NumArray(nums)
# numArray.sumRange(0, 1)
# numArray.update(1, 10)
# numArray.sumRange(1, 2)