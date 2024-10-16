class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rec(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode rec(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;  // Base case: no more elements to process
        }

        // The root is the first element of the current preorder range
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of the root in the inorder array
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Calculate the size of the left subtree
        int leftSubTreeSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = rec(preorder, preStart + 1, preStart + leftSubTreeSize, inorder, inStart, rootIndex - 1);
        root.right = rec(preorder, preStart + leftSubTreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
