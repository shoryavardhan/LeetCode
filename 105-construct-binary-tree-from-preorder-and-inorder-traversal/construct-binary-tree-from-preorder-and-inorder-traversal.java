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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         return rec(preorder, inorder);
    }

    public TreeNode rec(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        var root = preorder[0];
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(root, null, null);
        }
        
        //travelling to root
        int i = 0;
        while (inorder[i] != root) {
            i++;
        }
        var n = preorder.length;
        var leftSubTreeSize = i;
        var rightSubTreeSize = n - i - 1;
        
        //InOrder slicing
        var leftInOrder = new int[leftSubTreeSize];
        int k = 0;
        for (int j = 0; j < leftSubTreeSize; j++) {
            leftInOrder[k] = inorder[j];
            k++;
        }
        var rightInOrder = new int[rightSubTreeSize];
        k = 0;
        for (int j = leftSubTreeSize + 1; j < n; j++) {
            rightInOrder[k] = inorder[j];
            k++;
        }

        //PreOrder slicing
        var leftPreOrder = new int[leftSubTreeSize];
         k = 0;
        for (int j = 1; j <= leftSubTreeSize; j++) {
            leftPreOrder[k] = preorder[j];
            k++;
        }
        var rightPreOrder = new int[rightSubTreeSize];
        k = 0;
        for (int j = leftSubTreeSize + 1; j < n; j++) {
            rightPreOrder[k] = preorder[j];
            k++;
        }

        var left = rec(leftPreOrder,leftInOrder);
        var right = rec(rightPreOrder,rightInOrder);

        return new TreeNode(root, left, right);
    }
}