class Solution {
    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums, nums.length - 1);
    }

    public int dp(int[] nums, int i) {
        if (i == 0) {
             memo[i] = nums[i];
            return memo[i];
        }
        if (i < 0) {
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        var pick = nums[i] + dp(nums, i - 2);
        var notPick = dp(nums, i - 1);
        memo[i] = Math.max(pick, notPick);
        return memo[i];
    }
}