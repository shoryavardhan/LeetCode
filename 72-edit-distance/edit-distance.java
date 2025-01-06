class Solution {
    public int minDistance(String word1, String word2) {
        return bottomUp2(word1, word2);
    }

    public int bottomUp2(String word1, String word2) {
        int[] prev = new int[word2.length() + 1];
        for (int j = 0; j <= word2.length(); j++) {
            prev[j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            int[] curr = new int[word2.length() + 1];
            curr[0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = 0 + prev[j - 1];
                } else {
                    var replaced = 1 + prev[j - 1];
                    var deleted = 1 + prev[j];
                    var added = 1 + curr[j - 1];
                    curr[j] = Math.min(replaced, Math.min(deleted, added));
                }
            }
            prev = curr;
        }

        return prev[word2.length()];
    }

    public int bottomUp(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            memo[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            memo[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = 0 + memo[i - 1][j - 1];
                } else {
                    var replaced = 1 + memo[i - 1][j - 1];
                    var deleted = 1 + memo[i - 1][j];
                    var added = 1 + memo[i][j - 1];
                    memo[i][j] = Math.min(replaced, Math.min(deleted, added));
                }
            }
        }

        return memo[word1.length()][word2.length()];
    }

    public int topDown(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(word1, word2, word1.length(), word2.length(), memo);
    }

    public int dp(String word1, String word2, int i, int j, int[][] memo) {
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = 0 + dp(word1, word2, i - 1, j - 1, memo);
        } else {
            var replaced = 1 + dp(word1, word2, i - 1, j - 1, memo);
            var deleted = 1 + dp(word1, word2, i - 1, j, memo);
            var added = 1 + dp(word1, word2, i, j - 1, memo);
            memo[i][j] = Math.min(replaced, Math.min(deleted, added));
        }
        return memo[i][j];
    }
}