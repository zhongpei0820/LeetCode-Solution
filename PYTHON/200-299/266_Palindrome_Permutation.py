# Given a string, determine if a permutation of the string could form a palindrome.

# For example,
# "code" -> False, "aab" -> True, "carerac" -> True.

#Solution:
from collections import Counter
class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        return len(filter(lambda item : item[1] % 2, Counter(s).items())) <= 1
        
#Another equivalent solution:
from collections import Counter
class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        return len([item for item in Counter(s).items() if item[1] % 2]) <= 1