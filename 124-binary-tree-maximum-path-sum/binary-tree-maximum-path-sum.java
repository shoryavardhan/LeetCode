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
    private int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        var x = mps(root);
        System.out.println(x);
        return maxi;
    }

    public int mps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = Math.max(0,mps(root.left));
        int rh = Math.max(0,mps(root.right));
        int localMax = lh + rh + root.val;
        maxi = Math.max(localMax, maxi);
        return Math.max(lh, rh) + root.val;
    }
}
