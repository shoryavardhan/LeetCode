class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1)
            return 1;
        var timeStack = new Stack<Double>();
        int n = position.length;
        int[][] pairs = new int[n][2];
       
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, java.util.Comparator.comparingInt(p -> p[0]));
        for (int i = 0; i < n; i++) {

        }
        for (int i = n - 1; i >= 0; i--) {
            var currCarTime = (double)(target - pairs[i][0]) / pairs[i][1];
            // System.out.println(currCarTime);
            if (!timeStack.isEmpty() && currCarTime <= timeStack.peek()) {
                continue;
            } else {
                timeStack.push(currCarTime);
            }
        }
        return timeStack.size();
    }
}