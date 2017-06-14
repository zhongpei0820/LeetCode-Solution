#
#    Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
#    You may assume that each word will contain only lower case letters.
#    If no such two words exist, return 0.
#
#
#
#    Example 1:
#
#
#    Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
#    Return 16
#    The two words can be "abcw", "xtfn".
#
#
#    Example 2:
#
#
#    Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
#    Return 4
#    The two words can be "ab", "cd".
#
#
#    Example 3:
#
#
#    Given ["a", "aa", "aaa", "aaaa"]
#    Return 0
#    No such pair of words.    
#
#
#Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.

class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        dict = {}
        # length = [len(words[i]) for i in range(0,len(words))]
        ret = 0
        for word in words:
            mask = 0
            for c in word:
                mask |= 1 << ord(c) - 97
            dict[mask] = max(dict.get(mask,0), len(word))
            
        for i in dict:
            for j in dict:
                if not i & j:
                    ret = max(ret,dict[i] * dict[j])
        return ret
            
            