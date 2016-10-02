// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//   / \
//   2   2
// / \ / \
// 3  4 4  3
// But the following is not:
//     1
//   / \
//   2   2
//   \   \
//   3    3


//Idea: 1. If the tree is null, return true;
//      2. If the tree doesn't have any child, return true;
//      3. If the tree is symmetric: The left node is equal to the right node;
//                                  The left child of the left node should be eqaul to the right child of the right node;
//                                  The right child of the left node should be equal to the left child of the right node.
//                                  So we check it recursively.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else return isSymmetricLevel(root.left,root.right);
    }
    
    public boolean isSymmetricLevel(TreeNode a, TreeNode b){
        return (a == null || b == null) ? a == b : a.val == b.val && isSymmetricLevel(a.left,b.right) && isSymmetricLevel(a.right,b.left);
    }
}
