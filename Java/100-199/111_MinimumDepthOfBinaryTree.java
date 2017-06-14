// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

//Idea: If root == null, return 0;
//      Minimum depth = min(Left minimum depth, Right minimum depth)

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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depthLeft = minDepth(root.left);
        int depthRight = minDepth(root.right);
        if(root.left == null && root.right == null) return 1;
        if(root.left == null && root.right != null) return 1 + depthRight;
        if(root.left != null && root.right == null) return 1 + depthLeft;
        else return 1 + Math.min(depthLeft, depthRight);
    }
}
