class Solution {
    public boolean increasingTriplet(int[] nums) {
        var f = Integer.MAX_VALUE;
        var s = Integer.MAX_VALUE;
        for(var num : nums){
            if(num<f){
                f=num;
            }
            if(num>f && num<s){
                s=num;
            }
            if(num>f && num>s){
                return true;
            }
        }
        return false;
    }
}