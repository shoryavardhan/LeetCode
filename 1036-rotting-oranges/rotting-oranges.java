class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        var fresh = 0;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair<>(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }

            }
        }
        if (fresh == 0) {
            return 0;
        }
        var time = bfs(q, grid, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }

            }
        }
        return time;

    }

    public int bfs(Queue<Pair<Integer, Integer>> q, int[][] grid, int m, int n) {
        var time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                var pair = q.poll();
                var x = pair.getKey();
                var y = pair.getValue();
                addNeighbor(q, x + 1, y, m, n, grid);
                addNeighbor(q, x, y + 1, m, n, grid);
                addNeighbor(q, x - 1, y, m, n, grid);
                addNeighbor(q, x, y - 1, m, n, grid);
            }
            time++;

        }
        return time - 1;
    }

    public void addNeighbor(Queue<Pair<Integer, Integer>> q, int newX, int newY, int m, int n, int[][] grid) {
        if (newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 1) {
            grid[newX][newY] = 2;
            q.add(new Pair<>(newX, newY));
        }
    }
}
