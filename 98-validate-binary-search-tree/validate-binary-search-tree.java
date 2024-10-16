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
    static boolean ans;
    static TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        ans = true;
        prev = null;
        inorder(root);
        return ans;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            ans = false;
        }
        prev = root;
        inorder(root.right);
    }
}