#
#Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
#
#
#For example:
#
#
#Given s = "aabb", return ["abba", "baab"].
#
#
#Given s = "abc", return [].
#
from collections import Counter
class Solution(object):
    def generatePalindromes(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        dict = {}
        for c in s:
            if not dict.has_key(c) : dict[c] = 1
            else : dict[c] += 1
        if len([dict[x] for x in dict if dict[x] % 2 != 0]) > 1 : return []
        half = ''
        mid = ''
        ret = []
        for c in dict:
            for i in range(0,dict[c] / 2) : half += c
            if dict[c] % 2 == 1:
                mid = c
                
        self.backTracking(half,0,'',mid,ret)
        return ret

    def backTracking(self,half,index,currStr,mid,ret):
        if index == len(half):
            ret.append(currStr + mid + currStr[::-1])
            return
        for i in range(0,len(currStr) + 1):
            self.backTracking(half,index + 1,currStr[:i] + half[index] + currStr[i:],mid,ret)
            if i < len(currStr) and currStr[i] == half[index] : break
                    
        
