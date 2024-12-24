class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // int[][] memo = new int[m][n];
        // return dp(grid, m, n, m - 1, n - 1, memo);
        return tabluation(grid, m, n);
    }

    public int tabluation(int[][] grid, int m, int n) {
        int[][] memo = new int[m][n];
        // memo[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = grid[0][0];
                } else {
                    int up = (i > 0) ? memo[i - 1][j] : Integer.MAX_VALUE;
                    int left = (j > 0) ? memo[i][j - 1] : Integer.MAX_VALUE;
                    memo[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return memo[m - 1][n - 1];
    }

    public int dp(int[][] grid, int m, int n, int i, int j, int[][] memo) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int up = 0;
        int left = 0;
        if (i > 0) {
            up = dp(grid, m, n, i - 1, j, memo);
        }
        if (j > 0) {
            left = dp(grid, m, n, i, j - 1, memo);
        }
        memo[i][j] = grid[i][j] + Math.min(up, left);
        return memo[i][j];
    }
}
