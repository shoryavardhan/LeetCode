class Solution {
    public int maxArea(int[] a) {
        int i = 0;
        int j = a.length-1;
        int max = 0 ;
        while(i<j){
            int area = (j-i)*min(a[i],a[j]);
            if(area>max){
                max = area;
            }
            if(a[i]<a[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }

    private int min(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }
}