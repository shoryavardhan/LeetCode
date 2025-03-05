/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("n,");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        var s = data.split(",");
        return helper(s);
    }

    public TreeNode helper(String[] s) {
        if (s[index].equals("n")) {
            index++;
            return null;
        }
        var node = new TreeNode(Integer.valueOf(s[index]));
        index++;
        node.left = helper(s);
        node.right = helper(s);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));