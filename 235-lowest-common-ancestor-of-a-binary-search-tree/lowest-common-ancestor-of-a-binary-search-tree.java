/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return lowestCommonAncestorBT(root, p, q);
        return lowestCommonAncestorBST(root, p, q);
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        //p ko chota or q ko bda wala lena h
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        //agar dono bde h to right subtree me honge, agr dono chote h to left me honge 
        //or agar esa nhi h iska mtl yahi lca h
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else {
                return root;
            }
        }
        return null;
    }



    public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {

        // basically left jao or right jao ek ek krke, agr p ya q h tb to return kro nhi to null return kro, to koi node h usme agr niche se dono left and right se value aari h mtlb yahi pehla ancestor h nhi to ek jagah se to null hi aaega, is code me BST ka fyada nhi uthaya gya
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}