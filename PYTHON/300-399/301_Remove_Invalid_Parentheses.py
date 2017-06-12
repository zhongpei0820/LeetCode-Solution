#
#Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
#
#Note: The input string may contain letters other than the parentheses ( and ). 
#
#
#
#Examples:
#
#"()())()" -> ["()()()", "(())()"]
#"(a)())()" -> ["(a)()()", "(a())()"]
#")(" -> [""]
#
#
#
#Credits:Special thanks to @hpplayer for adding this problem and creating all test cases.
class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        hashset = set()
        hashset.add(s)
        stack = []
        for i,ch in enumerate(s):
            if ch == '(' : stack.append((ch,i))
            elif ch == ')' :
                if len(stack) == 0 : stack.append((ch,i))
                elif stack[-1][0] == '(' : stack.pop()
                else : stack.append((ch,i))
        while len(stack) != 0:
            curr = stack.pop()
            nextset = set()
            if curr[0] == '(':
                for s in hashset:
                    for i in range(curr[1],len(s)):
                        if s[i] == '(' : nextset.add(s[:i] + s[i + 1:])
            elif curr[0] == ')':
                for s in hashset:
                    for i in range(0,curr[1] + 1):
                        if s[i] == ')' : nextset.add(s[:i] + s[i + 1:])
            hashset = nextset
        return list(hashset)