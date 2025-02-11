class Solution {
    public int minCostConnectPoints(int[][] points) {
        var adjList = getAdjList(points);
    //    var maxSum = doBFS(adjList, points);
        var minSum = doPrims(adjList, points);
        return minSum;
    }

    public int doPrims(HashMap<Integer, List<int[]>> adjList, int[][] points) {
        if(points.length==1){
			return 0;
		}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] visited = new int[points.length];
        int sum = 0;
        List<int[]> edges = new ArrayList<int[]>();
        minHeap.offer(new int[] { 0, 0, -1 });
        while (!minHeap.isEmpty()) {
            var top = minHeap.poll();
            var cost = top[0];
            var index = top[1];
            var costFrom = top[2];

            if (visited[index] == 1)
                continue;

            visited[index] = 1;
            if (costFrom != -1) {
                sum += cost;
                edges.add(new int[] { index, costFrom });
            }
            var neighbors = adjList.get(index);
            for (var neigh : neighbors) {
                var newCost = neigh[0];
                var newIndex = neigh[1];
                if (visited[newIndex] != 1) {
                    minHeap.offer(new int[] { newCost, newIndex, index });
                }
            }
        }
        for (var edge : edges) {
            System.out.print("(" + edge[1] + "," + edge[0] + "), ");
        }
        return sum;

    }

    public int doBFS(HashMap<Integer, List<int[]>> adjList, int[][] points) {
        if(points.length==1){
			return 0;
		}
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] visited = new int[points.length];
        int sum = 0;
        q.add(new Pair<>(0, 0)); // index 0 and cost 0
        while (!q.isEmpty()) {
            var cur = q.poll();
            var index = cur.getKey();
            var cost = cur.getValue();
            visited[index] = 1;
            sum += cost;
            var neighbours = adjList.get(index);
            for (var neigh : neighbours) {
                var costToNew = neigh[0];
                var newIndex = neigh[1];
                if (visited[newIndex] != 1) {
                    q.offer(new Pair<>(newIndex, costToNew));
                }
            }

        }
        return sum;

    }

    public HashMap<Integer, List<int[]>> getAdjList(int[][] points) {
        var n = points.length;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                var dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] { dis, j });
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] { dis, i });
            }
        }
        return map;
    }
}