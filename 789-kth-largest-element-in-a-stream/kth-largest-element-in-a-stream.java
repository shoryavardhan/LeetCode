class KthLargest {
    List<Integer> minHeap = new ArrayList<Integer>();
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
            var i = minHeap.size() - 1;
            while (i > 0) {
                var parent = (i - 1) / 2;
                if (minHeap.get(i) < minHeap.get(parent)) {
                    swap(parent, i);
                    i = parent;
                } else {
                    break;
                }
            }
        } else if (val > minHeap.get(0)) {
            deleteRoot();
            minHeap.add(val);
            var i = minHeap.size() - 1;
            while (i > 0) {
                var parent = (i - 1) / 2;
                if (minHeap.get(i) < minHeap.get(parent)) {
                    swap(parent, i);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        return minHeap.get(0);
    }

    public int deleteRoot() {
        if (minHeap.size() == 0) {
            System.out.println("Heap is empty !!");
            return -1;
        }
        var top = minHeap.get(0);
        var n = minHeap.size();
        swap(0, n - 1);
        minHeap.remove(n - 1);
        n = minHeap.size();
        var i = 0;
        while (true) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;

            int smallerChild = -1;
            if (leftIndex < n && rightIndex < n) {
                smallerChild = (minHeap.get(leftIndex) < minHeap.get(rightIndex)) ? leftIndex : rightIndex;
            } else if (leftIndex < n) {
                smallerChild = leftIndex;
            } else {
                return top; // No children left to compare
            }

            if (minHeap.get(smallerChild) < minHeap.get(i)) {
                swap(smallerChild, i);
                i = smallerChild;
            } else {
                return top; // No need to swap since even the bigger child is smaller
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = minHeap.get(index1);
        minHeap.set(index1, minHeap.get(index2));
        minHeap.set(index2, temp);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */