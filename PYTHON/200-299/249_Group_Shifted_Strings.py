#Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
#"abc" -> "bcd" -> ... -> "xyz"
#
#Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
#
#For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
#A solution is:
#
#[
#  ["abc","bcd","xyz"],
#  ["az","ba"],
#  ["acef"],
#  ["a","z"]
#]
class Solution(object):
    def groupStrings(self, strings):
        """
        :type strings: List[str]
        :rtype: List[List[str]]
        """
        dict = collections.defaultdict(list)
        for str in strings:
            dict[self.getOrigin(str)].append(str)
        return dict.values()
        
    def getOrigin(self,string):
        offset = ord(string[0]) - ord('a')
        if offset == 0 : return string
        ret = ""
        for i in string:
            diff = ord(i) - offset
            print diff
            if diff < ord('a'): diff += 26
            ret += chr(diff)
        return ret    
        