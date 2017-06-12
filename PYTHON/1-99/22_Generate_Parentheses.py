# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

# For example, given n = 3, a solution set is:

# [
#   "((()))",
#   "(()())",
#   "(())()",
#   "()(())",
#   "()()()"
# ]

class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ret = []
        left,right = 0,0
        self.helper("",ret,left,right,n)
        return ret
    
    def helper(self,branch,ret,left,right,n):
        if len(branch) == n * 2:
            ret.append(branch)
        if left < n:
            self.helper(branch + "(", ret, left + 1, right,n)
        if right < left:
            self.helper(branch + ")", ret, left, right + 1,n)