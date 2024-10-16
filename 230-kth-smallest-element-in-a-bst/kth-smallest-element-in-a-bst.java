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
    static int val;
    static int current;

    public int kthSmallest(TreeNode root, int k) {
        current = 1;
        val = -1;
        inorder(root, k);
        return val;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        if (current == k) {
            val = root.val;
        }
        current++;
        inorder(root.right, k);

    }
}