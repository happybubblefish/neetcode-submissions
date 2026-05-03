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
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }

        getDepth(root);

        return res;
    }

    private int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        res = Math.max(left + right, res);

        return 1 + Math.max(left, right);
    }
}
