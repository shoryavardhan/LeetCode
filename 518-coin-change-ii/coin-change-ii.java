class Solution {
    public int change(int amount, int[] coins) {
        // return topDown(amount, coins);
        return tabulation(amount, coins);
    }

    public int tabulation(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                memo[0][target] = 1;
            } else {
                memo[0][target] = 0;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int target = 0; target <= amount; target++) {
                var nottake = memo[i-1][target];
                var take = 0;
                if (target >= coins[i]) {
                    take = memo[i][target - coins[i]];
                }
                memo[i][target] = take + nottake;
            }
        }
        return memo[coins.length-1][amount];
    }

    public int topDown(int amount, int[] coins) {
        int[][] memo = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(amount, coins, coins.length - 1, memo);
    }

    public int dp(int target, int[] coins, int i, int[][] memo) {
        if (i == 0) {
            if (target % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (target < 0) {
            return 0;
        }
        if (memo[i][target] != -1) {
            return memo[i][target];
        }
        var nottake = dp(target, coins, i - 1, memo);
        var take = 0;
        if (target >= coins[i]) {
            take = dp(target - coins[i], coins, i, memo);
        }
        memo[i][target] = take + nottake;
        return memo[i][target];
    }
}