// Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

// For example:
// Given a binary tree {1,2,3,4,5},
//     1
//    / \
//   2   3
//  / \
// 4   5
// return the root of the binary tree [4,5,2,#,#,3,1].
//    4
//   / \
//  5   2
//     / \
//    3   1  

// Solution 1 : Recursive

// Find the left most one as the new root.
// Switch right to the left, left to the current root.

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}

// Solution 2 : Iteration

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode temp = null;
        TreeNode next = null;
        while(curr != null){
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}