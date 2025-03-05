class Solution {
    public String longestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        var lcSubSeq = longestCommonSubsequence(s, t);
        System.out.println(lcSubSeq);
        var lcSubStr = longestCommonSubstring(s, t);
        System.out.println(lcSubStr);
        var lcSubStr2 = longestCommonSubstring2(s);
        return lcSubStr2;
    }

    public String longestCommonSubstring2(String s) {
        var res = "";
        var resLen = 0;
        // odd
        for (int i = 0; i < s.length(); i++) {
            var l = i;
            var r = i;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    res = s.substring(l, r+1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        // even
        for (int i = 0; i < s.length(); i++) {
            var l = i;
            var r = i + 1;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resLen) {
                    res = s.substring(l, r+1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return res;
    }

    public String longestCommonSubstring(String s, String t) {
        int[][] memo = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            memo[i][0] = 0;
            memo[0][i] = 0;
        }
        int itr2 = -1;
        int maxi = -1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                    int len = memo[i][j];
                    if (len > maxi && (i - len) == (s.length() - j)) {
                        maxi = memo[i][j];
                        itr2 = i;
                    }
                } else {
                    memo[i][j] = 0;
                }
            }
        }

        int i = itr2 - maxi;
        int j = itr2;
        String ans = s.substring(i, j);
        return ans;
    }

    public String longestCommonSubsequence(String s, String t) {
        int[][] memo = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            memo[i][0] = 0;
            memo[0][i] = 0;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = 0 + Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        String ans = "";
        int i = s.length();
        int j = s.length();
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                ans = s.charAt(i - 1) + ans;
                i = i - 1;
                j = j - 1;
            } else {
                if (memo[i - 1][j] > memo[i][j - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }
        }
        return ans;
    }
}
