class Solution {
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length() + 1][p.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, p, s.length(), p.length(), memo) == 1;
    }

    public int dp(String s, String p, int i, int j, int[][] memo) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (j == 0) {
            return 0;
        }

        if (i == 0) {
            if (j > 1 && p.charAt(j - 1) == '*') {
                return dp(s, p, i, j - 2, memo); 
            }
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
            memo[i][j] = dp(s, p, i - 1, j - 1, memo);
        }

        else if (p.charAt(j - 1) == '*') {
          
            boolean zeroOccurrences = dp(s, p, i, j - 2, memo) == 1;
            boolean oneOrMoreOccurrences =
                (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                && dp(s, p, i - 1, j, memo) == 1;

            memo[i][j] = (zeroOccurrences || oneOrMoreOccurrences) ? 1 : 0;
        }

        else {
            memo[i][j] = 0;
        }

        return memo[i][j];
    }
}
