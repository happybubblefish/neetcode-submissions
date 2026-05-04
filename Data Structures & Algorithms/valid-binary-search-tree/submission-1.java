/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }

        return dfs(root.left, null, root.val) && dfs(root.right, root.val, null);
    }

    private boolean dfs(TreeNode root, Integer lower, Integer upper) {
        if(root == null) {
            return true;
        }

        if(lower != null && root.val <= lower || upper != null && root.val >= upper) {
            return false;
        }

        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }
}
