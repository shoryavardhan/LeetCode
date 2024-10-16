class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var max = 0;
        var n = piles.length;
        for (int i = 0; i < n; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        var left = 1;
        var right = max;
        var minSpeed = max;
        while (left <= right) {
            var speed = (left + right) / 2;
            long time = 0;
            for (int i = 0; i < n; i++) {
                time = time + (long) (piles[i] + speed - 1) / speed;
            }
            if (time > h) {
                left = speed + 1;
            }
            if (time <= h) {
                minSpeed = speed;
                right = speed - 1;

            }
        }
        return minSpeed;
    }
}