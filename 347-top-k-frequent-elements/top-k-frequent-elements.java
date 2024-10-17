class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;

        var frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            var frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            System.out.println(i + "->" + bucket[i]);
        }

        int[] res = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int i : bucket[pos]) {
                    res[counter++] = i;
                }
            }
        }
        return res;
    }
}