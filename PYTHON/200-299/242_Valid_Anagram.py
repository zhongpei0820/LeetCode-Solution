#Given two strings s and t, write a function to determine if t is an anagram of s. 
#
#For example,
#s = "anagram", t = "nagaram", return true.
#s = "rat", t = "car", return false.
#
#
#Note:
#You may assume the string contains only lowercase alphabets.
#
#Follow up:
#What if the inputs contain unicode characters? How would you adapt your solution to such case?

class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dict = {}
        for i in s:
            if not dict.has_key(i):
                dict[i] = 1
            else:
                dict[i] += 1
        
        for i in t:
            if not dict.has_key(i):
                return False
            else:
                dict[i] -= 1
        
        for i in dict:
            if dict[i] != 0:
                return False
        
        return True