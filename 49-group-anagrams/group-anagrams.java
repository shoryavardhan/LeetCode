class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        int i = 0;
        while (i < strs.length) {
            var key = sortString(strs[i]);
            List<String> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key);
            }
            list.add(strs[i]);
            map.put(key, list);

            i++;
        }
        List<List<String>> finalList = new ArrayList<>();
        for (var entry : map.entrySet()) {
            finalList.add(entry.getValue());
        }
        return finalList;
    }

    private String sortString(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}