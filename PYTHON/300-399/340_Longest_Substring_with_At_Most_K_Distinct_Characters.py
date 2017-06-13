#
#Given a string, find the length of the longest substring T that contains at most k distinct characters.
#
#
#
#For example,
#
#Given s = “eceba” and k = 2,
#
#
#
#T is "ece" which its length is 3.
#

class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        dict = {}
        low = 0
        maxLength = 0
        for i in range(0,len(s)):
            dict[s[i]] = i
            if len(dict) > k:
                low = min(dict.values())
                dict.pop(s[low])
                low += 1
            maxLength = max(maxLength, i - low + 1)
        return maxLength