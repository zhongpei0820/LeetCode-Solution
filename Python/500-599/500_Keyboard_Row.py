#Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below. 
#
#
#
#
#
#
#
#Example 1:
#
#Input: ["Hello", "Alaska", "Dad", "Peace"]
#Output: ["Alaska", "Dad"]
#
#
#
#Note:
#
#You may use one character in the keyboard more than once.
#You may assume the input string will only contain letters of alphabet.
#
#

class Solution(object):
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        dict = {
            1 : 'qwertyuiopQWERTYUIOP',
            2 : 'asdfghjklASDFGHJKL',
            3 : 'zxcvbnmZXCVBNM'
        }
        ret = []
        for word in words:
            row = 1
            if word[0] in dict[2]: row = 2
            if word[0] in dict[3]: row = 3
            f = True
            for c in word:
                if c not in dict[row]:
                    f = False    
                    break
            if f: ret.append(word)
        return ret