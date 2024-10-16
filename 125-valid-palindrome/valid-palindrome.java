class Solution {
    public boolean isPalindrome(String s) {
        var l = 0;
        var r = s.length() - 1;

        while (l < r) {
            var leftChar = s.charAt(l);
            if (!isCharOrNum(leftChar)) {
                l++;
                continue;
            }

            var rightChar = s.charAt(r);
            if (!isCharOrNum(rightChar)) {
                r--;
                continue;
            }
            if (isCapChar(leftChar)) {
                leftChar = (char) (leftChar - 'A' + 'a');
            }
            if (isCapChar(rightChar)) {
                rightChar = (char) (rightChar - 'A' + 'a');
            }
            if (leftChar == rightChar) {
                l++;
                r--;
            } else {
                return false;
            }

        }
        return true;
    }

    private boolean isCharOrNum(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
    }

    private boolean isCapChar(char c) {
        return ('A' <= c && c <= 'Z');
    }

}