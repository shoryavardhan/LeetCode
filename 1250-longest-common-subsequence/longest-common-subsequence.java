class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return topDown(text1, text2);
        return bottomUp(text1, text2);

    }

    public int bottomUp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            memo[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            memo[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    var leftString = memo[i][j - 1];
                    var rightString = memo[i - 1][j];
                    memo[i][j] = 0 + Math.max(leftString, rightString);
                }
            }
        }
        return memo[m][n];

    }

    public int topDown(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dpOnStrings(text1, text2, text1.length(), text2.length(), memo);
    }

    public int dpOnStrings(String text1, String text2, int i1, int i2, int[][] memo) {
        if (i1 == 0 || i2 == 0) {
            return 0;
        }
        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
            memo[i1][i2] = 1 + dpOnStrings(text1, text2, i1 - 1, i2 - 1, memo);
        } else {
            var leftString = dpOnStrings(text1, text2, i1, i2 - 1, memo);
            var rightString = dpOnStrings(text1, text2, i1 - 1, i2, memo);
            memo[i1][i2] = 0 + Math.max(leftString, rightString);
        }
        return memo[i1][i2];
    }
}