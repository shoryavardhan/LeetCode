class Solution {
    public int countSubstrings(String s) {
        var res = 0;
        for (int i = 0; i < s.length(); i++) {
            var l = i;
            var r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            var l = i;
            var r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
        }
    return res;
    }
}