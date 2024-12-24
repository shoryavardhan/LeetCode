class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        return dp(grid, m, n, m - 1, n - 1, memo);
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
        int up = dp(grid, m, n, i - 1, j, memo);
        int left = dp(grid, m, n, i, j - 1, memo);
        memo[i][j] = grid[i][j] + Math.min(up, left);
        return memo[i][j];
    }
}
