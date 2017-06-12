# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

# BFS

class Solution(object):
    def depthSum(self, nestedList):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        depth,curr = 1,0
        while nestedList:
            curr += depth * sum([x.getInteger() for x in nestedList if x.isInteger()])
            nestedList = sum([x.getList() for x in nestedList if not x.isInteger()],[])
            depth += 1
        return curr
        
#DFS
class Solution(object):
    def depthSum(self, nestedList,depth = 1):
        """
        :type nestedList: List[NestedInteger]
        :rtype: int
        """
        sum = 0
        for i in nestedList : 
            if i.isInteger() :
                sum += depth * i.getInteger()
            else:
                sum += self.depthSum(i.getList(),depth + 1)
        return sum
        
        