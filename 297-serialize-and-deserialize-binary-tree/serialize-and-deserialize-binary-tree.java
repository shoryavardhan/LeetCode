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
        String s = preOrder(root);
        System.out.println(s);
        return s;
    }

    public String preOrder(TreeNode root) {
        if (root == null) {
            return "n";
        }
        String sb = ""+root.val;
        sb = sb + ","+ preOrder(root.left);
        sb = sb + ","+ preOrder(root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var s = data.split(",");
        index =0;
        return helper(s);
    }
    public TreeNode helper(String[] s){
        if(s[index].equals("n")){
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