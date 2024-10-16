class Solution {
    public int search(int[] a, int target) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(a[mid]==target){
                return mid;
            }

            //left portion is 100% sorted
            if(a[l]<=a[mid]){
                //is target in right portion?
                if(target>a[mid] || target < a[l]){
                    l=mid+1;
                } 
                //is target in current i.e., left portion?
                else{
                    r=mid-1;
                }
            }

            //right portion is 100% sorted
            else{
                  //is target in left portion?
                if(target<a[mid] || target> a[r]){
                    r=mid-1;
                }
                //is target in current i.e., right portion?
                else{
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}