class Solution {
    public int numIslands(char[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        var num = 0;
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !set.contains(new Pair<>(i, j))) {
                    set.add(new Pair<>(i, j));
                    bfs(grid, set, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void bfs(char[][] grid, HashSet<Pair<Integer, Integer>> set, int i, int j) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        var m = grid.length;
        var n = grid[0].length;
        q.offer(new Pair<>(i, j));
        while (!q.isEmpty()) {
            var pair = q.poll();
            var x = pair.getKey();
            var y = pair.getValue();
            //System.out.println("Visiting: " + x + ", " + y);
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