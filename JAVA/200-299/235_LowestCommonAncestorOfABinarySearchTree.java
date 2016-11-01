//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

//Idea: check if p and q are in the same subtree of root. If yes, do it recursively on the left subtree or right subtree. Otherwise, return root.

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         TreeNode node = root;
         if(p.val < node.val && q.val > node.val) return node;
         else if(p.val > node.val && q.val < node.val) return node;
        //  else if(p.val == node.val || q.val == node.val) return node;
         else if(p.val > node.val && q.val > node.val) return lowestCommonAncestor(node.right,p,q);
         else if(p.val < node.val && q.val < node.val) return lowestCommonAncestor(node.left,p,q);
         return node;
    }
}
