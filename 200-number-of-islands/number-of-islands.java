class Solution {
    public int numIslands(char[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        var num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' ) {
                    dfs(grid, i, j, m, n);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int newX, int newY, int m, int n) {
        if (newX < 0 || newY < 0 || newX >= m || newY >= n  || grid[newX][newY] == '0') {
            return;
        }

         grid[newX][newY] = '0';
        dfs(grid, newX + 1, newY, m, n);
        dfs(grid, newX - 1, newY, m, n);
        dfs(grid, newX, newY + 1, m, n);
        dfs(grid, newX, newY - 1, m, n);
    }

}