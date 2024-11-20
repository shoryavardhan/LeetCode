class Solution {

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = l + (r-l) / 2;
            if (nums[mid] >= nums[r]) { // agar mid wala right wale se bda h to left side to ho hi nhi skta h deflection point 
                l = mid + 1;
            } else {// agar mid wala right wale se chota  h to right side to ho hi nhi skta h deflection point
                r = mid;
            }
        }
        return 0;
    }
}