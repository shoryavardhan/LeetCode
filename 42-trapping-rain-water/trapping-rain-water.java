class Solution {
    public int trap(int[] a) {
        int l=0;
        int r=a.length-1;
        int lmx=0;
        int rmx=0;
        int res = 0;

        while(l<=r){
            if(a[l]<=a[r]){
                if(a[l]>=lmx){
                    lmx = a[l];
                }
                else{
                    res = res + lmx - a[l];
                }
                l++;
            }
            else{
                if(a[r]>=rmx){
                    rmx=a[r];
                }
                else{
                    res = res + rmx - a[r];
                }
                r--;
            }
        }
        return res;
    }
}