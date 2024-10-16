class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, 0, 0, "", res);
        return res;

    }

    private void backtrack(int n, int open, int close, String s, List<String> res) {
        if(s.length()==2*n){
            res.add(s);
            return;
        }
        if (open < n) {
            backtrack(n, open+1, close, s + "(", res);
        }
        if (close < open) {
            backtrack(n, open, close+1, s + ")", res);
        }
    }
}