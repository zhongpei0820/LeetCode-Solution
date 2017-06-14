#
#All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
#
#Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
#
#
#For example,
#
#Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
#
#Return:
#["AAAAACCCCC", "CCCCCAAAAA"].
#

from sets import Set
class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        # dict = {'A' : 0, 'C' : 1, 'G' : 2, 'T' : 3}
        set = Set()
        ret = Set()
        for i in range(0,len(s) - 9):
            if s[i:i+10] in set:
                ret.add(s[i:i+10])
            else:
                set.add(s[i:i+10])
            # v = 0
            # for c in s[i : i + 10]:
            #     v |= dict[c]
                # v <<= 2
            # if v in set:
            #     ret.add(s[i : i + 10])
            # else:
            #     set.add(v)
        return list(ret)
        