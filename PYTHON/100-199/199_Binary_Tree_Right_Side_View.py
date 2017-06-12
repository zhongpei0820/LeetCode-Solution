#Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
#
#
#For example:
#Given the following binary tree,
#
#   1            <---
# /   \
#2     3         <---
# \     \
#  5     4       <---
#
#
#
#You should return [1, 3, 4].
#
#
#Credits:Special thanks to @amrsaqr for adding this problem and creating all test cases.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ret = []
        if root == None : return ret
        def bfs(nodes):
            if len(nodes) == 0 : return
            nextLevel = []
            for node in nodes:
                if node.left != None : nextLevel.append(node.left)
                if node.right != None : nextLevel.append(node.right)
            ret.append(nodes[-1].val)
            bfs(nextLevel)
        bfs([root])
        return ret
        
    