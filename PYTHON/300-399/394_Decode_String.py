#
#Given an encoded string, return it's decoded string.
#
#
#The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
#
#
#You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
#
#Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
#
#
#Examples:
#
#s = "3[a]2[bc]", return "aaabcbc".
#s = "3[a2[c]]", return "accaccacc".
#s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
#
#

class Solution(object):
    def decodeString(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) == 0 : return ""
        stack = []
        res = ""
        i = 0
        while i < len(s):
            if s[i].isdigit():
                num = ""
                while s[i].isdigit():
                    num += s[i]
                    i += 1
                stack.append(num)
            if s[i] != ']':
                stack.append(s[i])
            else:
                curr = ""
                while len(stack) > 0 and stack[len(stack) - 1] != '[':
                    curr = stack.pop() + curr
                stack.pop()
                number = int(stack.pop())
                curr *= number
                stack.append(curr)
            i += 1
        while len(stack) != 0:
           res = stack.pop() + res
        return res