#A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
#Each LED represents a zero or one, with the least significant bit on the right.
#
#For example, the above binary watch reads "3:25".
#
#Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
#
#Example:
#Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
#
#
#Note:
#
#The order of output does not matter.
#The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
#The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
#
#

class Solution(object):
    def readBinaryWatch(self, num):
        """
        :type num: int
        :rtype: List[str]
        """
        # ret = []
        # for i in range(0,12):
        #     for j in range(0,60):
        #         if (bin(i) + bin(j)).count('1') == num : ret.append('%d:%02d' %(i,j)) 
        # return ret
        
        hour = [1,2,4,8]
        min = [1,2,4,8,16,32]
        ret = []
        for i in range(0,num + 1):
            list1 = self.readBinary(i,hour)
            list2 = self.readBinary(num - i,min)
            for h in list1:
                if h < 12:
                    for m in list2:
                        if m < 60:
                            ret.append('%d:%02d' %(h,m))
        return ret
            
            
    def readBinary(self,num,list):
        ret = []
        self.backTracking(num,list,0,0,ret)
        return ret
        
    def backTracking(self,num,list,start,sum,ret):
        if num == 0:
            ret.append(sum)
            return
        for i in range(start,len(list)):
            self.backTracking(num - 1,list,i + 1,sum + list[i],ret)
        
        
        
        
        
        
        
        