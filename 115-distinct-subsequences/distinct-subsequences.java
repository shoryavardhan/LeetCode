class Solution {
    public int numDistinct(String s, String t) {
        // return topDown(s,t);
        return bottomUp(s, t);
    }

    public int bottomUp(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            memo[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            memo[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[m][n];
    }

    public int topDown(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(s, t, s.length() - 1, t.length() - 1, memo);
    }

    public int dp(String s, String t, int i, int j, int[][] memo) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            memo[i][j] = dp(s, t, i - 1, j - 1, memo) + dp(s, t, i - 1, j, memo);
        } else {
            memo[i][j] = dp(s, t, i - 1, j, memo);
        }
        return memo[i][j];
    }
}