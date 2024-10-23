class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int i=0;
        while(i<nums.length){
            pq.offer(nums[i]);
            i++;
        }
        i =0;
        while(i<k-1){
            pq.poll();
            i++;
        }
        return pq.peek();
        
    }
}