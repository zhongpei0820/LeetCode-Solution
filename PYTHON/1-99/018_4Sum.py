#Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
#
#Note: The solution set must not contain duplicate quadruplets.
#
#
#
#For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
#
#A solution set is:
#[
#  [-1,  0, 0, 1],
#  [-2, -1, 1, 2],
#  [-2,  0, 0, 2]
#]
#
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if len(nums) < 4 : return []
        nums = sorted(nums)
        if nums[0] * 4 > target or nums[-1] * 4 < target : return[]
        ret = []
        for i in range(0,len(nums) - 3):
            if nums[i] * 4 >  target : break;
            if nums[i] + nums[-1] + nums[-2] + nums[-3] < target : continue 
            if nums[i] * 4 == target and i < len(nums) - 3 and nums[i + 3] == nums[i]:
                ret.append([nums[i],nums[i],nums[i],nums[i]])
                break
            if i != 0 and nums[i] == nums[i - 1]: continue
            self.threeSum(nums[i + 1:],target - nums[i],ret,nums[i])
        return ret
                
        
        
    def threeSum(self,nums,target,ret,curr):
        for i in range(0,len(nums) - 2):
            if nums[i] * 3 > target : break;
            if nums[i] + nums[-1] + nums[-2] < target : continue
            if nums[i] * 3 == target and i < len(nums) - 3 and nums[i + 2] == nums[i]:
                ret.append([curr,nums[i],nums[i],nums[i]])
                break
            if i != 0 and nums[i] == nums[i - 1]: continue
            self.twoSum(nums[i + 1:],target - nums[i],ret,curr,nums[i])
            
    
    def twoSum(self,nums,target,ret,curr,curr2):
        low,high = 0,len(nums) - 1
        if nums[low] * 2 > target or nums[high] * 2 <target:
            return;
        while low < high:
            sum = nums[low] + nums[high]
            if sum == target:
                ret.append([curr,curr2,nums[low],nums[high]])
            if sum <= target:
                while low < high and nums[low] == nums[low + 1]:
                    low += 1
                low +=1
            if sum >= target:
                while low < high and nums[high] == nums[high - 1]:
                    high -= 1
                high -= 1
            
        
        