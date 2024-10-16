class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
              if(s.charAt(i)=='('){
                stack.push(')');
            }
            else if(s.charAt(i)=='{'){
                stack.push('}');
            }
            else if(s.charAt(i)=='['){
                stack.push(']');
            }
             else if(stack.isEmpty() || stack.pop()!=s.charAt(i)){
                return false;
            }
            i++;
        }
        return stack.isEmpty();
    }
}