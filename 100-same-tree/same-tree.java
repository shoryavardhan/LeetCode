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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        boolean areValuesEqual = (p.val == q.val);
        var isLeftTreeEqual = isSameTree(p.left, q.left);
        var isRightTreeEqual = isSameTree(p.right, q.right);

        return areValuesEqual && isLeftTreeEqual && isRightTreeEqual;

    }
}