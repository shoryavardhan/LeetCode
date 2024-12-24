class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dp(m, n, m - 1, n - 1, memo);
    }

    public int tab(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0) {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[m-1][n-1];
    }

    public int dp(int m, int n, int i, int j, int[][] memo) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        var up = dp(m, n, i - 1, j, memo);
        var down = dp(m, n, i, j - 1, memo);
        memo[i][j] = up + down;

        return memo[i][j];
    }
}