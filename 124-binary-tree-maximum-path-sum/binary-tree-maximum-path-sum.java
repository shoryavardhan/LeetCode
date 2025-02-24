/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxx = Integer.MIN_VALUE / 2;

    public int maxPathSum(TreeNode root) {
        var x = rec(root);
        return maxx;
    }

    public int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var lh = rec(root.left);
        if (lh < 0)
            lh = 0;
        var rh = rec(root.right);
        if (rh < 0)
            rh = 0;
        if (maxx < root.val + lh + rh) {
            maxx = root.val + lh + rh;
        }
        return root.val + Math.max(lh, rh);
    }
}