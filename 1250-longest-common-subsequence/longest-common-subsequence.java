class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1, text2, text1.length(), text2.length());
    }

    public int dp(String t1, String t2, int m, int n) {
        int[] curr = new int[n + 1];
        int[] prev = new int[n + 1];

        prev[0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    var left = prev[j];
                    var right = curr[j - 1];
                    curr[j] = Math.max(left, right);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n + 1);
        }

        return curr[n];
    }
}