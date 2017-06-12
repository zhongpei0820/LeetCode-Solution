#Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
#The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
#
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for c in s:
            if len(stack) == 0:
                stack.append(c)
            elif (stack[-1] == '(' and c == ')') or (stack[-1] == '[' and c == ']') or (stack[-1] == '{' and c == '}'):
                    stack.pop()
            else: stack.append(c)
        return len(stack) == 0
        