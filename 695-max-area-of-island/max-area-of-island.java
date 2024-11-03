class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        var maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, m, n));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        var a = dfs(grid, i + 1, j, m, n);
        var b = dfs(grid, i, j + 1, m, n);
        var c = dfs(grid, i - 1, j, m, n);
        var d = dfs(grid, i, j - 1, m, n);
        return a + b + c + d + 1;
    }
}