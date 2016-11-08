# Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

# For example, given nums = [-2, 0, 1, 3], and target = 2.

# Return 2. Because there are two triplets which sums are less than 2:

# [-2, 0, 1]
# [-2, 0, 3]
# Follow up:
# Could you solve it in O(n2) runtime?

class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        ret = 0
        nums.sort()
        for i in range(0,len(nums) - 2):
            if nums[i] > target / 3 : break;
            low,high = i + 1,len(nums) - 1
            while low < high:
                sum = nums[i] + nums[low] + nums[high] 
                if sum < target:
                    ret += high - low;
                    low += 1
                else:
                    high -= 1
        return ret