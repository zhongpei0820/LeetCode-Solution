#Given an array of strings, group anagrams together.
#
#
#For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
#Return:
#
#[
#  ["ate", "eat","tea"],
#  ["nat","tan"],
#  ["bat"]
#]
#
#Note: All inputs will be in lower-case.
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dict = collections.defaultdict(list)
        ret = []
        for str in strs:
            key = ''.join(sorted(str))
            dict[key].append(str)
        return dict.values()
            # flag = False
            # for key in dict.keys():
            #     if self.isAnagrams(key,i): 
            #         dict[key].append(i)
            #         flag = True
            #         break
            # if flag == False:
            #     dict[i] = [i]
        
        # ret = []
        # for i in dict.values():
        #     ret.append(i)
        # return ret
                
        
    # def isAnagrams(self,str1,str2):
    #     dict = {}
    #     for i in str1:
    #         if dict.has_key(i):
    #             dict[i] += 1
    #         else: dict[i] = 1
    #     for i in str2:
    #         if dict.has_key(i):
    #             dict[i] -= 1
    #         else: return False
    #     for i in dict:
    #         if dict[i] != 0:return False
    #     return True
        # return sorted(str1) == sorted(str2)