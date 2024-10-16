class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String ss = new String(chars);
        chars = t.toCharArray();
        Arrays.sort(chars);
        String st = new String(chars);
        if(ss.equals(st)){
            return true;
        }
        else{
            return false;
        }
    }
}