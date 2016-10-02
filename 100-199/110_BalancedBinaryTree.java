// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

//Idea: check : 1. If right subtree and left subtree are height-balanced binary tree.
//              2. If the depth of the two subtrees differs no more than 1.

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return (Math.abs(depth(root.left) - depth(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int depth(TreeNode node){
        int depth_left = 0, depth_right = 0;
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        if(node.left != null) depth_left = 1 + depth(node.left);
        if(node.right != null) depth_right = 1 + depth(node.right);
        return Math.max(depth_left,depth_right);
    }
}
