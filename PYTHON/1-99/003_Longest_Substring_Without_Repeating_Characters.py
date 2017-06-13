#Given a string, find the length of the longest substring without repeating characters.
#
#Examples:
#
#Given "abcabcbb", the answer is "abc", which the length is 3.
#
#Given "bbbbb", the answer is "b", with the length of 1.
#
#Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 0:
            return 0
        dict = {}
        start = -1
        maxLength = 0
        for i in range(0,len(s)):
            if s[i] not in dict:
                dict[s[i]] = i
            else:
                if(dict[s[i]]) >= start:
                    start = dict[s[i]]
                dict[s[i]] = i
            maxLength = max(maxLength,i - start)
        return maxLength
        