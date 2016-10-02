// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//   / \
//   9  20
//     /  \
//   15   7
// return its bottom-up level order traversal as:
// [
//   [15,7],
//   [9,20],
//   [3]
// ]


//Idea: BFS, store each level into list, reverse the list

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < count; i++){
                TreeNode node = q.poll();
                
                if(node.left != null){
                     q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                list.add(node.val);
            }
            if(!list.isEmpty()){
                res.add(list);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
