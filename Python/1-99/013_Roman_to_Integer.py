#Given a roman numeral, convert it to an integer.
#
#Input is guaranteed to be within the range from 1 to 3999.

class Solution(object):
    
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        dict = {'M':1000,'D':500,'C':100,'L':50,'X':10,'V':5,'I':1}
        res = 0
        a = map(lambda x: dict[x],s)
        for i in range(0,len(a)):
            if i + 1 < len(a) and a[i] < a[i + 1]:
                res -= a[i]
            else:
                res += a[i]
        return res