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
    int count = 0;
    int res = Integer.MAX_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return res;
        }

        kthSmallest(root.left, k);

        count++;
        if(count == k) {
            res = root.val;
            return res;
        }

        kthSmallest(root.right, k);

        return res;
    }
}
