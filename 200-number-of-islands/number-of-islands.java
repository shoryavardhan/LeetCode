class Solution {
    public int numIslands(char[][] grid) {
        return solByBFS(grid);
    }

    public int solByBFS(char[][] grid) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        var ans = 0;
        for(int i =0; i< m;i++){
            for(int j = 0; j<n ;j++){
                if(grid[i][j]=='1'&& !set.contains(new Pair<>(i, j))){
                    var pair = new Pair<>(i,j);
                    set.add(pair);
                    q.offer(pair);
                    bfs(grid, q, set);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, Queue<Pair<Integer, Integer>> q, HashSet<Pair<Integer, Integer>> set) {
            while(!q.isEmpty()){
                var pair = q.poll();
                var x = pair.getKey();
                var y = pair.getValue();
                addNeighbour(grid, q, set, x+1, y);
                addNeighbour(grid, q, set, x, y+1);
                addNeighbour(grid, q, set, x-1, y);
                addNeighbour(grid, q, set, x, y-1);
            }
    }
    public void addNeighbour(char[][] grid, Queue<Pair<Integer, Integer>> q, HashSet<Pair<Integer, Integer>> set, int x, int y){
        if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && !set.contains(new Pair<>(x,y))&& grid[x][y] == '1'){
            set.add(new Pair<>(x,y));
            q.offer(new Pair<>(x,y));
        }
    }

    public int solByDFS(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y, m, n);
        dfs(grid, x - 1, y, m, n);
        dfs(grid, x, y + 1, m, n);
        dfs(grid, x, y - 1, m, n);
    }
}