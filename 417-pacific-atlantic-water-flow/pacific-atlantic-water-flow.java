class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        HashSet<Pair<Integer, Integer>> pac = new HashSet<>();
        HashSet<Pair<Integer, Integer>> atl = new HashSet<>();

        for (int c = 0; c < n; c++) {
            dfs(0, c, heights, -1,  pac);
            dfs(m - 1, c, heights, -1, atl);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, heights, -1, pac);
            dfs(r, n - 1, heights, -1, atl);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (var val : pac) {
            if (atl.contains(val)) {
                List<Integer> sub = new ArrayList<>();
                sub.add(val.getKey());
                sub.add(val.getValue());
                ans.add(sub);
            }
        }
        return ans;
    }

    public void dfs(int r, int c, int[][] h, int prev, HashSet<Pair<Integer, Integer>> visited) {
        if (r < 0 || c < 0 || r >= h.length || c >= h[0].length || h[r][c] < prev || visited.contains(new Pair<>(r, c))) {
            return;
        }
        visited.add(new Pair<>(r, c));
        prev = h[r][c];
        dfs(r + 1, c, h, prev, visited);
        dfs(r, c + 1, h, prev, visited);
        dfs(r - 1, c, h, prev, visited);
        dfs(r, c - 1, h, prev, visited);

    }
}
