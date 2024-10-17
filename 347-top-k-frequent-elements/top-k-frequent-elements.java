class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      /*
         * need to create buckets of (count,list),
         * the key will be the count and the value will be
         * the list of elements occured that many times
         * 
         * ex- 2,4,4,5,5
         * 2 occures 1 times and 4 occures 2 times and 5 also occurs 2 times
         * then the List would be
         * 
         * (0->[]),(1->[2]),(2->[4,5]),(3->[]),(4->[])
         * 
         * 0 to 4 because there are 5 elements in the list.
         * now to get top k we will traverse from the back and return;
         */

        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        for (int key : frequencyMap.keySet()) {
            var frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        for (int i=0;i< nums.length+1;i++) {
            System.out.println(i+"->"+bucket[i]);
        }

        int[] res = new int[k];
        int counter = 0;

      for(int pos = bucket.length-1;pos>=0 && counter<k;pos--){
        if(bucket[pos]!=null){
            for(int i:bucket[pos]){
                res[counter++]=i;
            }
        }
      }

        return res;
				
				    }
}