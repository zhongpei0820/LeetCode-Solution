// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
// Show Company Tags
// Show Tags
// Hide Similar Problems


//Idea : search the node in the binary tree recursively. Compare the difference between target and each node, return the 
//closest node value.

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
    public int closestValue(TreeNode root, double target) {
        TreeNode node = (root.val > target) ? root.left : root.right;
        if(node == null) return root.val;
        int value = closestValue(node,target);
        return Math.abs(root.val - target) < Math.abs(value - target) ? root.val : value;
    }
}
