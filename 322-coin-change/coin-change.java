class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> map = new HashMap<>();
        var ans = rec(coins, amount, map);
        return (ans >= Integer.MAX_VALUE) ? -1 : ans;

    }

    public int rec(int[] coins, int sumStillRequired, HashMap<Integer, Integer> map) {
        if (sumStillRequired == 0)
            return 0; //no coin required

        var res = Integer.MAX_VALUE; 

        for (var coin : coins) {
            if (sumStillRequired - coin >= 0) {
                int subRes = 0;
                if (map.containsKey(sumStillRequired - coin)) {
                    subRes = map.get(sumStillRequired - coin);
                } else {
                    subRes = rec(coins, sumStillRequired - coin, map);
                }
                if (subRes != Integer.MAX_VALUE && subRes + 1 < res) {
                    res = subRes + 1;
                }
            }

        }
        map.put(sumStillRequired, res);
        return res;
    }
}