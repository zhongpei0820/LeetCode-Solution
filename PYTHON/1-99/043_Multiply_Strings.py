#Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
#
#Note:
#
#The length of both num1 and num2 is < 110.
#Both num1 and num2 contains only digits 0-9.
#Both num1 and num2 does not contain any leading zero.
#You must not use any built-in BigInteger library or convert the inputs to integer directly.
#
#
class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        res = [0 for i in range(0,len(num1) + len(num2))]
        for i in range(len(num1) - 1,-1,-1):
            for j in range(len(num2) - 1,-1,-1):
                sum = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0')) + res[i + j + 1]
                res[i + j] += sum / 10
                res[i + j + 1] = sum % 10
        i = 0
        while i < len(res) and res[i] == 0: i += 1
        if i == len(res) : return '0'
        return ''.join(map(lambda x : str(x),res[i:]))
        # res = ''.join(map(lambda x : str(x),res))
        # i = 0
        # while i < len(res) - 1 and res[i] == '0' : i += 1
        # return res[i:]
        
            