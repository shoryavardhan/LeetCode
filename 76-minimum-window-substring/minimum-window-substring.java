class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        var map = new HashMap<Character, Integer>();
        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        var l = 0;
        var r = 0;
        var minStart = 0;
        var minLen = Integer.MAX_VALUE;
        var tdone = 0;
        
        while (r < s.length()) {
            var rc = s.charAt(r);
            if (map.containsKey(rc)) {
                if (map.get(rc) > 0) {
                    tdone++;
                }
                map.put(rc, map.get(rc) - 1);
            }
            r++;

            while (tdone == t.length()) { 
                if (r - l < minLen) {
                    minLen = r - l;
                    minStart = l;
                }
                var lc = s.charAt(l);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) {
                        tdone--;
                    }
                }
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
