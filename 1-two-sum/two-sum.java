class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer,Integer>();
        var ans = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
            }
            else{
                map.put(nums[i],i);
            }
        }
        
        return ans;
    }
}