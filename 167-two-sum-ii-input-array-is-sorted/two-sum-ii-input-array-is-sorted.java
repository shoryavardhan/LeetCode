class Solution {
    public int[] twoSum(int[] numbers, int target) {
       var res = new int[2];
       var l = 0;
       var r = numbers.length-1;
       while(l<r){
        if(numbers[l]+numbers[r]==target){
            res[0]=l+1;
            res[1]=r+1;
            return res;
        }
        else if(numbers[l]+numbers[r]<target){
            l++;
        }
        else{
            r--;
        }
       }
       return res;
    }
}