#
#Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
#
#
#
#For example,
#
#Given s = “eceba”,
#
#
#
#T is "ece" which its length is 3.
#
class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0: return 0
        dict = {}
        start = 0
        maxLength = 0
        for i in range(len(s)):
            # print s[i]
            dict[s[i]] = i
            if len(dict) > 2:
                currMin = len(s)
                for ch in dict:
                    if dict[ch] < currMin: currMin = dict[ch]
                    start = dict[s[currMin]] + 1
                del dict[s[currMin]]
            maxLength = max(maxLength, i - start + 1)
        return maxLength