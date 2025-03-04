class Solution {
    public int maxProduct(int[] nums) {
        var negp = 0;
        var posp = 0;
        negp = nums[0];
        posp = nums[0];
        var p = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempPos = posp; 
            posp = Math.max(nums[i], Math.max(nums[i] * posp, nums[i] * negp));
            negp = Math.min(nums[i], Math.min(nums[i] * tempPos, nums[i] * negp));
            p = Math.max(p, posp);
            System.out.println("3rd- " + negp + " " + posp + " " + nums[i]);
        }
        return p;
    }
}