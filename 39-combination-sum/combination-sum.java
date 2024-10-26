class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var ans = rec(new ArrayList<>(), 0, new ArrayList<>(), 0, target, candidates);
        return ans;
    }

    public List<List<Integer>> rec(List<Integer> combi, int sumSoFar, List<List<Integer>> ans, int ind, int target,
            int[] candidates) {
        if (sumSoFar == target) {
            ans.add(new ArrayList<>(combi));
            return ans;
        }
        if (sumSoFar > target || ind >= candidates.length) {
            return ans;
        }
        combi.add(candidates[ind]);
        sumSoFar += candidates[ind];
        rec(combi, sumSoFar, ans, ind, target, candidates);
        combi.remove(combi.size() - 1);
        sumSoFar -= candidates[ind];
        rec(combi, sumSoFar, ans, ind + 1, target, candidates);
        return ans;
    }
}