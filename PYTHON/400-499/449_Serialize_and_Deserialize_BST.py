#Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment. 
#
#Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
#
#
#The encoded string should be as compact as possible.
#
#
#
#Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
#
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def helper(root):
            ret = ""
            if root == None : return ret
            ret += str(root.val)
            left,right = helper(root.left),helper(root.right)
            if left != "" : ret += "," + left
            if right != "" : ret += "," + right
            return ret
        return helper(root)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if len(data) == 0 : return None
        nodes = map(int,data.split(","))
        def helper(nodes):
            if len(nodes) == 0 : return None
            node = TreeNode(nodes[0])
            if len(nodes) > 1:
                index = 1
                while index < len(nodes) and nodes[index] < nodes[0] : index += 1
                node.left = helper(nodes[1:index])
                node.right = helper(nodes[index:])
            return node
        return helper(nodes)
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))