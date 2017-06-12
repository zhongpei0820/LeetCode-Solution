#
#Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
#
#Example:
#Given num = 16, return true.
#Given num = 5, return false.
#
#
#Follow up: Could you solve it without loops/recursion?
#
#Credits:Special thanks to @yukuairoy  for adding this problem and creating all test cases.
class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 0: return False
        return not num & num - 1 and num & 0x55555555 == num