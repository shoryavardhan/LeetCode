class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new Stack<Integer>();
        var res = new int[temperatures.length];
        int currDay = 0;
        while (currDay < temperatures.length) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currDay]) {
                var prevDay = stack.pop();
                var diff = currDay - prevDay;
                res[prevDay] = diff;

            }
            stack.push(currDay);
            currDay++;
        }
        return res;
    }
}