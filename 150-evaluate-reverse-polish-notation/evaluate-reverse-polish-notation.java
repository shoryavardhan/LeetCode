class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                var second = stack.pop();
                var first = stack.pop();
                var res = 0;
                if (tokens[i].equals("+")) {
                    res = first + second;
                }
                if (tokens[i].equals("-")) {
                    res = first - second;
                }
                if (tokens[i].equals("*")) {
                    res = first * second;
                }
                if (tokens[i].equals("/")) {
                    res = first / second;
                }
                stack.push(res);

            } else
                stack.push(Integer.parseInt(tokens[i]));
            i++;
        }
        return stack.peek();
    }
}