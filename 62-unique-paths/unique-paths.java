class Solution {
    public int uniquePaths(int m, int n) {
        return tab2(m, n);
    }

    public int tab2(int m, int n) {
        var prev = new int[n];
        for (int i = 0; i < m; i++) {
            var temp = new int[n];
            for (int j = 0; j < n; j++) {
                var up = 0;
                var left = 0;
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = temp[j - 1];
                    }
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}