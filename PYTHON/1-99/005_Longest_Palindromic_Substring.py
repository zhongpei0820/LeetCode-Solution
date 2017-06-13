#Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
#
#Example:
#
#Input: "babad"
#
#Output: "bab"
#
#Note: "aba" is also a valid answer.
#
#
#
#Example:
#
#Input: "cbbd"
#
#Output: "bb"
#
#

class Solution(object):
    
    # def __init__(self):
    #     self.maxlength = 1
    #     self.start = 0
    
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) < 2: return s
        maxlength,start,i = 1,0,0
        while i < len(s):
            if maxlength / 2 > len(s) - i : break
            left,right = i,i
            while right < len(s) - 1 and s[right] == s[right + 1]:
                right += 1
            i = right + 1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                right += 1
                left -= 1
            currLength = right - left - 1
            if maxlength < currLength:
                maxlength = currLength
                start = left + 1
            # self.helper(i,i,s)
            # self.helper(i,i + 1,s)
        return s[start : start + maxlength]
        
    # def helper(self,left,right,s):
    #     while right < len(s) - 1 and s[right] == s[right + 1]:
    #         right += 1
    #     while left >= 0 and right < len(s) and s[left] == s[right]:
    #         right += 1
    #         left -= 1
    #     currLength = right - left - 1
    #     if self.maxlength < currLength:
    #         self.maxlength = currLength
    #         self.start = left + 1
        