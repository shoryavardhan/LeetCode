class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return optimalApproach(nums);
    }

    public List<List<Integer>> optimalApproach(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> betterApproach(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            var set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                var third = -(nums[i] + nums[j]);

                if (!set.isEmpty() && set.contains(third)) {
                    List<Integer> sortedList = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(sortedList);
                    res.add(sortedList);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }
}