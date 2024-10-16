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
    public int goodNodes(TreeNode root) {
        return preOrder(root, root.val);
    }

    public int preOrder(TreeNode root, Integer max) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val >= max) {
            max = root.val;
            count = 1;

        }
        count += preOrder(root.left, max);
        count += preOrder(root.right, max);
        return count;
    }
}