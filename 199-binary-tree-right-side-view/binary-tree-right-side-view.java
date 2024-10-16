class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // Handle the case where the tree is empty
        if (root == null) {
            return new ArrayList<>();
        }

        // TreeMap to store the rightmost node at each level
        TreeMap<Integer, Integer> levelWiseValues = new TreeMap<>();
        
        // Queue to store pairs of (level, node)
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        
        // Start with the root node at level 0
        q.offer(new Pair<>(0, root));
        
        while (!q.isEmpty()) {
            Pair<Integer, TreeNode> current = q.poll();
            int level = current.getKey();
            TreeNode node = current.getValue();

            // Keep updating the node at this level (rightmost node for each level)
            levelWiseValues.put(level, node.val);

            // Add left and right children to the queue with the next level
            if (node.left != null) {
                q.offer(new Pair<>(level + 1, node.left));
            }
            if (node.right != null) {
                q.offer(new Pair<>(level + 1, node.right));
            }
        }

        // Prepare the result list
        List<Integer> res = new ArrayList<>();
        for (var itr : levelWiseValues.values()) {
            res.add(itr);
        }
        
        return res;
    }
}