class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(cost[i + 1] , cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);

    }
    // public int minCostClimbingStairs(int[] cost) {
    // int[] memo = new int[cost.length];
    // Arrays.fill(memo,-1);
    // var a = dp(cost, 0,memo);
    // var b = dp(cost, 1,memo);
    // return Math.min(a, b);
    // }

    // public int dp(int[] cost, int i,int[] memo) {
    // if (i >= cost.length) {
    // return 0;
    // }
    // if(memo[i]!=-1){
    // return memo[i];
    // }
    // memo[i]= cost[i] + Math.min(dp(cost, i + 1,memo), dp(cost, i + 2,memo));
    // return memo[i];
    // }
}
