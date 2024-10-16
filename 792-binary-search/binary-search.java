class Solution {
    public int search(int[] nums, int target) {
         int  i =0;
        int j = nums.length-1;
        while(i<=j){
            var mid = (i+j)/2;
            if((nums[mid])<target){
                i= mid+1;
            }
            else{
                j=mid-1;
            }
            if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}