#Given a set of words (without duplicates), find all word squares you can build from them.
#
#A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 &le; k &lt; max(numRows, numColumns).
#
#For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
#
#
#b a l l
#a r e a
#l e a d
#l a d y
#
#
#Note:
#
#There are at least 1 and at most 1000 words.
#All words will have the exact same length.
#Word length is at least 1 and at most 5.
#Each word contains only lowercase English alphabet a-z.
#
#
#
#Example 1:
#
#Input:
#["area","lead","wall","lady","ball"]
#
#Output:
#[
#  [ "wall",
#    "area",
#    "lead",
#    "lady"
#  ],
#  [ "ball",
#    "area",
#    "lead",
#    "lady"
#  ]
#]
#
#Explanation:
#The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
#
#
#
#Example 2:
#
#Input:
#["abat","baba","atan","atal"]
#
#Output:
#[
#  [ "baba",
#    "abat",
#    "baba",
#    "atan"
#  ],
#  [ "baba",
#    "abat",
#    "baba",
#    "atal"
#  ]
#]
#
#Explanation:
#The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
#
#
class Solution(object):
    def wordSquares(self, words):
        """
        :type words: List[str]
        :rtype: List[List[str]]
        """
        dict = {}
        n = len(words[0])
        ret = []
        for word in words:
            for i in range(1,n):
                if word[:i] in dict:
                    dict[word[:i]].append(word)
                else:
                    dict[word[:i]] = [word]
        print dict
        for word in words:
            self.backTrack(dict,[word], 1, n, ret)
        return ret
        
    def backTrack(self, dict, square, index, length, ret):
        if index == length:
            ret.append(square)
            return
        prefix = ""
        for word in square:
            prefix += word[index]
        # print prefix
        if not prefix in dict : return
        for word in dict[prefix]:
            self.backTrack(dict,square + [word],index + 1, length, ret)
            