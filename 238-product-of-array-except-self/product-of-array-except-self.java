class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        int p = 1;
        for (int i = 0; i < n; i++) {
            result[i] = result[i] * p;
            p = p * nums[i];
        }
        int s = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * s;
            s = s * nums[i];
        }
        return result;
    }
}

/*
 * array -> 1. 2. 3. 4.
 * prefix -> 1 2 6 24
 * suffix-> 24 24 12 4
 * 
 * 
 * but if we move prefix a bit ahead and pull suffix it will give us what we
 * need like
 * 
 * array -> 1 2 3 4
 * prefix -> 1 1 2 6 24
 * suffix-> 24 24 12 4 1
 * result -> 24 12 8 6
 * 
 */