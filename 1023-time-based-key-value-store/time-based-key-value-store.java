class TimeMap {
    HashMap<String, List<Pair<String, Integer>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        var list = timeMap.get(key);
        return search(list, timestamp);
    }

    private String search(List<Pair<String, Integer>> list, Integer timestamp) {
        int l = 0;
        int r = list.size()-1;
        while (l < r) {
            int mid = l + (r - l+1) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (list.get(l).getValue() <= timestamp) {
            return list.get(l).getKey();
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */