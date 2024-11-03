class Solution {
    public int numIslands(char[][] grid) {
        var m = grid.length;
        var n = grid[0].length;
        var num = 0;
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

    public void dfs(char[][] grid, int newX, int newY, int m, int n, HashSet<Pair<Integer, Integer>> set) {
        if (newX < 0 || newY < 0 || newX >= m || newY >= n || set.contains(new Pair<>(newX, newY))
                || grid[newX][newY] == '0') {
            return;
        }

        set.add(new Pair<>(newX, newY));
        dfs(grid, newX + 1, newY, m, n, set);
        dfs(grid, newX - 1, newY, m, n, set);
        dfs(grid, newX, newY + 1, m, n, set);
        dfs(grid, newX, newY - 1, m, n, set);
    }

}