#
#Divide two integers without using multiplication, division and mod operator.
#
#
#If it is overflow, return MAX_INT.
#

class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if divisor == 0 : return -1
        if dividend == 0 :return 0
        if dividend == -2**31 and divisor == -1 : return 2**31 - 1
        sign = (divisor > 0) ^ (dividend > 0)
        dividend,divisor = abs(dividend),abs(divisor)
        ret = 0
        while dividend - divisor >= 0:
            temp = divisor
            count = 1
            while (temp << 1) <= dividend:
                temp <<= 1
                count <<= 1
            ret += count
            dividend -= temp
        if sign : ret = -ret
        return ret