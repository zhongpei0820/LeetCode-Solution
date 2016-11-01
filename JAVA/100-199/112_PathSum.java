// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//             / \
//             4   8
//           /   / \
//           11  13  4
//         /  \      \
//         7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

//Idea: 1. sum = sum - node.val
//      2. Search left sub-tree and right sub-tree recursively.
//      3. On the leaf node, see if sum - node.val == 0, if yes, return true, if not return false.

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0)return true; 
        boolean left = false, right = false;
        if(root.left != null) left = hasPathSum(root.left,sum);
        if(root.right != null) right = hasPathSum(root.right,sum);
        return left || right;
    }
}
