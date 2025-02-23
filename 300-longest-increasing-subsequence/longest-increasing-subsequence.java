class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        var memo = new int[n][n];
        for (var row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(nums, 1, 0, memo);
    }

    public int dp(int[] nums, int i, int prev, int[][] memo) {
        if (i == nums.length) {
            if (prev == 0 || nums[i - 1] > nums[prev - 1]) {
                return 1;
            }
            return 0;
        }
        if(memo[i][prev]!=-1){
            return memo[i][prev];
        }
        var notTake = dp(nums, i + 1, prev, memo);
        var take = 0;
        if (prev == 0 || nums[prev - 1] < nums[i - 1]) {
            take = 1 + dp(nums, i + 1, i, memo);
        }
        memo[i][prev] =  Math.max(take, notTake);
        return memo[i][prev];

    }
}