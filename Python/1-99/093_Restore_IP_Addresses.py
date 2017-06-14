#Given a string containing only digits, restore it by returning all possible valid IP address combinations.
#
#
#For example:
#Given "25525511135",
#
#
#return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
#

class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        ret = []
        self.backTracking(s,0,0,"",ret)
        return ret
        
    def backTracking(self,s,start,lvl,curr,ret):
        # print curr
        # print s[start:]
        if start >= len(s) : return
        if lvl == 3:
            if (s[start] == '0' and len(s[start:]) == 1) or (s[start] != '0' and int(s[start:]) <= 255):
                ret.append(curr + s[start:])
            return
        for i in range(start,min(start + 3,len(s))):
            temp = s[start : i + 1]
            if temp != '' and int(temp) <= 255:
                self.backTracking(s,i + 1,lvl + 1,curr + temp + ".",ret)
            if temp == '0' : break;
        