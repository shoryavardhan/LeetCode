class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return backtracking(new ArrayList<>(), new ArrayList<>(), 0, nums);
    }

    public List<List<Integer>> backtracking(List<List<Integer>> ans, List<Integer> ds, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        ds.add(nums[index]);
        backtracking(ans, ds, index + 1, nums);
        ds.remove(ds.size() - 1);
        backtracking(ans, ds, index + 1, nums);
        return ans;
    }
}