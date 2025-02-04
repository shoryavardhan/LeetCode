class Solution {
    HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    int[] inDeg;
    boolean[] vis;
     Queue<Integer> q = new LinkedList<>();
     Queue<Integer> rq = new LinkedList<>();

    public boolean canFinish(int n, int[][] pre) {
        // return canFinishByDfs(n, pre);
        inDeg = new int[n];
        vis = new boolean[n];
        return printTopoSort(n, pre);
    }

    public boolean printTopoSort(int n, int[][] pre) {
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] p : pre) {
            var co = p[0];
            var pr = p[1];
            adjList.get(co).add(pr);
            inDeg[pr]++;
        }
       
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.offer(i);
        }
        bfs();
        var size = rq.size();
        while(!rq.isEmpty()){
            System.out.print(rq.poll()+" ");
        }
        if(size==n){
            return true;
        }
        return false;
    }

    public void bfs() {
        while(!q.isEmpty()){
            var curr = q.poll();
            rq.offer(curr);
            for(int v : adjList.get(curr)){
                inDeg[v]--;
                if(inDeg[v]==0){
                    q.offer(v);
                }
            }
        }
    }

    HashSet<Integer> visited = new HashSet<>();

    public boolean canFinishByDfs(int n, int[][] pre) {
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] p : pre) {
            var co = p[0];
            var pr = p[1];
            adjList.get(co).add(pr);
        }

        for (int i = 0; i < n; i++) {
            var ans = dfs(i);
            if (ans == false) {
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int v) {
        if (visited.contains(v)) {
            return false;
        }
        if (adjList.get(v).size() == 0) {
            return true;
        }
        visited.add(v);
        for (int pr : adjList.get(v)) {
            if (!dfs(pr)) {
                return false;
            }
        }
        visited.remove(v);
        adjList.put(v, new ArrayList<>());
        return true;
    }
}
