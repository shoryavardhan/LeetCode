class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i<=word1.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(word1, word2, word1.length(), word2.length(), memo);
    }

    public int dp(String word1, String word2, int i, int j, int[][] memo) {
        if (i == 0 ){
            return j;
        }
        if(j == 0) {
            return i;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] =  0 + dp(word1, word2, i - 1, j - 1, memo);
        } else {
            var replaced = 1 + dp(word1, word2, i - 1, j - 1, memo);
            var deleted = 1 + dp(word1, word2, i - 1, j, memo);
            var added = 1 + dp(word1, word2, i, j - 1, memo);
            memo[i][j] = Math.min(replaced, Math.min(deleted, added));
        }
        return memo[i][j];
    }
}