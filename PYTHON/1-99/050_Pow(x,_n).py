#Implement pow(x, n).
#
class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if n < 0 : 
            x = 1 / x
            n = -n
        tmp = x
        res = 1
        i = 1
        while n > 0:
            if i * 2 <= n:
                tmp *= tmp
                i *= 2
                continue
            res *= tmp
            n -= i
            i = 1
            tmp = x
        return res
        