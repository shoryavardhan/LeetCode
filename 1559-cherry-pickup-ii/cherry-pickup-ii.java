class Solution {
    public int cherryPickup(int[][] grid) {
        // int[][][] memo = new int[grid.length][grid[0].length][grid[0].length];
        // return dp(grid, grid.length, grid[0].length, 0, 0, grid[0].length - 1, memo);
        return tablulation(grid, grid.length, grid[0].length);
    }

    public int tablulation(int[][] grid, int n, int m) {
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the
        // first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        return dp[0][0][m - 1];

    }

    public int dp(int[][] grid, int m, int n, int i, int j1, int j2, int[][][] memo) {
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return Integer.MIN_VALUE;
        }
        if (i == m - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }
        int[] dj = new int[] { -1, 0, 1 };
        var maxi = Integer.MIN_VALUE;
        if (memo[i][j1][j2] != 0) {
            return memo[i][j1][j2];
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int a = 0;
                if (j1 == j2) {
                    a = grid[i][j1];
                } else {
                    a = grid[i][j1] + grid[i][j2];
                }
                a = a + dp(grid, m, n, i + 1, j1 + dj[x], j2 + dj[y], memo);
                if (a > maxi)
                    maxi = a;
            }
        }
        memo[i][j1][j2] = maxi;
        return memo[i][j1][j2];
    }
}