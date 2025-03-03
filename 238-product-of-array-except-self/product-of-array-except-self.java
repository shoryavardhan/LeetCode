class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1 2 3 4
        // 1 1 2 6
        // 24 12 4 1
        // 24 12 8 6
        var n = nums.length;
        var p = new int[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * nums[i - 1];
        }
        var s = 1;
        for (int i = n - 1; i >= 0; i--) {
            p[i] = p[i] * s;
            s = s * nums[i];
        }
        return p;
    }
}