#Write a function to generate the generalized abbreviations of a word.
#
#
#    Example:
#
#Given word = "word", return the following list (order does not matter):
#["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
#
#
class Solution(object):
    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        ret = []
        total = 1 << len(word)
        for i in range(0,total):
            s = ""
            count = 0
            for j in range(0,len(word)):
                if i >> j & 1 :
                    if count != 0: s += str(count)
                    s += word[j]
                    count = 0
                else : count += 1
            if count != 0 : s += str(count)
            ret.append(s)
        return ret
            
        