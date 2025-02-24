class Solution {
    public int characterReplacement(String s, int k) {
        var n = s.length();
        var map = new HashMap<Character, Integer>();

        var l = 0;
        var r = 0;
        var maxc = 0;
        var res = 0;

        while (r < n) {
            var curr = s.charAt(r);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            maxc = Math.max(maxc, map.get(curr));

            var winLen = r - l + 1;

            if (winLen - maxc > k) {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;

    }
}