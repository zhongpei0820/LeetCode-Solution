#
#Given a binary tree, find the length of the longest consecutive sequence path.
#
#
#The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
#
#
#
#For example,
#
#   1
#    \
#     3
#    / \
#   2   4
#        \
#         5
#
#Longest consecutive sequence path is 3-4-5, so return 3. 
#
#   2
#    \
#     3
#    / 
#   2    
#  / 
# 1
#
#Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
#
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None : return 0
        return self.helper(root,1)
    
    def helper(self,root,currLength):
        if root.left == None and root.right == None : return currLength
        left,right = 0,0
        if root.left != None:
            if root.left.val - root.val == 1 :
                left = self.helper(root.left,currLength + 1)
            else:
                left = self.helper(root.left,1)
        if root.right != None:
            if root.right.val - root.val == 1:
                right = self.helper(root.right,currLength + 1)
            else:
                right = self.helper(root.right,1)
        return max(max(left,right),currLength)