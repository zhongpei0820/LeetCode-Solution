#
#Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
#
#
#Example 1:
#Input: 
#
#"bbbab"
#
#Output: 
#
#4
#
#One possible longest palindromic subsequence is "bbbb".
#
#
#Example 2:
#Input:
#
#"cbbd"
#
#Output:
#
#2
#
#One possible longest palindromic subsequence is "bb".
#
class Solution(object):
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        m = [[0] * len(s) for i in range(0,len(s))]
        for i in range(len(s)-1,-1,-1):
            m[i][i] = 1
            for j in range(i + 1,len(s)):
                if s[i] == s[j]: m[i][j] = m[i+1][j-1] + 2
                else: m[i][j] = max(m[i+1][j],m[i][j-1])
        return m[0][len(s) - 1]
        