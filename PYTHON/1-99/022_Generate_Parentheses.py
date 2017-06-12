#
#Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
#
#
#
#For example, given n = 3, a solution set is:
#
#
#[
#  "((()))",
#  "(()())",
#  "(())()",
#  "()(())",
#  "()()()"
#]
#
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ret = []
        self.backTracking(n,0,0,'',ret)
        return ret
        
    def backTracking(self,n,left,right,curr,ret):
        if left == right == n:
            ret.append(curr)
            return
        if left < n:
            self.backTracking(n,left + 1,right,curr + '(',ret)
        if right < left:
            self.backTracking(n,left,right + 1,curr + ')',ret)