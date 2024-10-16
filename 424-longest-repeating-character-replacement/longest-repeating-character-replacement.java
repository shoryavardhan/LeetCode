class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int l = 0, r = 0;
        var countMap = new HashMap<Character, Integer>();
        int maxCount = 0; // Tracks the count of the most frequent character in the current window

        while (r < s.length()) {
            Character c = s.charAt(r);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, countMap.get(c));

            // Calculate the window length
            int winLen = r - l + 1;

            // If the number of characters we need to replace is more than k, shrink the window from the left
            if (winLen - maxCount > k) {
                Character leftChar = s.charAt(l);
                countMap.put(leftChar, countMap.get(leftChar) - 1);
                l++;
            }

            // Update result if the current window length is valid
            res = Math.max(res, r - l + 1);

            r++;
        }

        return res;
    }
}