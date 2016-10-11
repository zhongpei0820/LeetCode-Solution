// Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

// Example:
// Given binary tree 
//           1
//          / \
//         2   3
//        / \     
//       4   5    
// Returns [4, 5, 3], [2], [1].

// Explanation:
// 1. Removing the leaves [4, 5, 3] would result in this tree:

//           1
//          / 
//         2          
// 2. Now removing the leaf [2] would result in this tree:

//           1          
// 3. Now removing the leaf [1] would result in the empty tree:

//           []         
// Returns [4, 5, 3], [2], [1].

// Solution:
// DFS, 
// if root.hasLeft && root.left is leave, add root.left, and set root.left = null.
// if root.left is not leave, findleaves(root.left).
// the same for root.right.
// Do DFS again, until root.left && root.right == null, which makes root a leave.
// add root, root = null.

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        while(root.left != null || root.right != null){
            list.add(getLeaves(root));
        }
        list.add(arr);
        root = null;
        return list;
    }
    
    private List<Integer> getLeaves(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                ret.add(root.left.val); 
                root.left = null;
            }
            else ret.addAll(getLeaves(root.left));
        }
        if(root.right != null){
            if(root.right.left == null && root.right.right == null){
                ret.add(root.right.val);
                root.right = null;
            }
            else ret.addAll(getLeaves(root.right));
        } 
        return ret;
    }
}