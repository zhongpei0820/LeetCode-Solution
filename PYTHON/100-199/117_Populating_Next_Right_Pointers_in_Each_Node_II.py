#Follow up for problem "Populating Next Right Pointers in Each Node".
#What if the given tree could be any binary tree? Would your previous solution still work?
#
#Note:
#You may only use constant extra space.
#
#
#For example,
#Given the following binary tree,
#
#         1
#       /  \
#      2    3
#     / \    \
#    4   5    7
#
#
#
#After calling your function, the tree should look like:
#
#         1 -> NULL
#       /  \
#      2 -> 3 -> NULL
#     / \    \
#    4-> 5 -> 7 -> NULL
#
#
# Definition for binary tree with next pointer.
# class TreeLinkNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root == None : return root
        q = collections.deque([root])
        while len(q) != 0:
            size = len(q)
            # nextLevel = []
            for i in range(size):
                curr = q.popleft()
                if i < size - 1 : curr.next = q[0]
                if curr.left != None : q.append(curr.left)
                if curr.right != None : q.append(curr.right)