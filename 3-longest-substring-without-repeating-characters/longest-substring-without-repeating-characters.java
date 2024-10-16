class Solution {
    public int lengthOfLongestSubstring(String s) {
        var set = new HashSet<Character>();
        var left = 0;
        var right = 0;
        var max =0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                if (right - left + 1 > max) {
                    max = right - left + 1;
                }
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}