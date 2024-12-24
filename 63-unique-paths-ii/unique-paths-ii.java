class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dp(m, n, m - 1, n - 1, memo, obstacleGrid);
    }

    public int dp(int m, int n, int i, int j, int[][] memo, int[][] obstacleGrid) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        var up = dp(m, n, i - 1, j, memo, obstacleGrid);
        var down = dp(m, n, i, j - 1, memo, obstacleGrid);
        memo[i][j] = up + down;

        return memo[i][j];
    }
}