class Solution {
    public int numIslands(char[][] grid) {
        return solutionByDFS(grid);
        // return solutionByBFS(grid);
    }

    public int solutionByDFS(char[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        var num = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !set.contains(new Pair<>(i, j))) {
                    dfs(grid, i, j, m, n, set);
                    num++;
                }
            }
        }
        return num;
    }

    public int solutionByBFS(char[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        var num = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !set.contains(new Pair<>(i, j))) {
                    set.add(new Pair<>(i, j));
                    q.offer(new Pair<>(i, j));
                    bfs(grid, q, set, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int newX, int newY, int m, int n, HashSet<Pair<Integer, Integer>> set) {
        if (newX < 0 || newY < 0 || newX >= m || newY >= n || set.contains(new Pair<>(newX, newY))
                || grid[newX][newY] == '0') {
            return;
        }

        set.add(new Pair<>(newX, newY));
        System.out.println("Visiting  " + newX + " " + newY);
        dfs(grid, newX + 1, newY, m, n, set);
        dfs(grid, newX - 1, newY, m, n, set);
        dfs(grid, newX, newY + 1, m, n, set);
        dfs(grid, newX, newY - 1, m, n, set);
    }

    public void bfs(char[][] grid, Queue<Pair<Integer, Integer>> q, HashSet<Pair<Integer, Integer>> set, int i, int j) {

        var m = grid.length;
        var n = grid[0].length;

        while (!q.isEmpty()) {
            var pair = q.poll();
            var x = pair.getKey();
            var y = pair.getValue();
            addNeighbor(q, set, x - 1, y, m, n, grid);
            addNeighbor(q, set, x, y - 1, m, n, grid);
            addNeighbor(q, set, x + 1, y, m, n, grid);
            addNeighbor(q, set, x, y + 1, m, n, grid);
        }
    }

    private void addNeighbor(Queue<Pair<Integer, Integer>> q, HashSet<Pair<Integer, Integer>> set, int newX, int newY,
            int m, int n, char[][] grid) {
        if (newX >= 0 && newY >= 0 && newX < m && newY < n && !set.contains(new Pair<>(newX, newY))
                && grid[newX][newY] == '1') {
            q.add(new Pair<>(newX, newY));
            set.add(new Pair<>(newX, newY));
        }
    }
}