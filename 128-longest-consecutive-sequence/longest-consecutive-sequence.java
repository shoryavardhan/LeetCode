class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int currLongest = 0;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + currLongest)) {
                    currLongest++;
                }
            }
            if (currLongest > longest) {
                longest = currLongest;
            }

        }
        return longest;
    }
}