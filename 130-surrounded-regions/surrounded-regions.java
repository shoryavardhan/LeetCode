class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for (int c = 0; c < n; c++) {
            dfs(0, c, board);
            dfs(m - 1, c, board);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, board);
            dfs(r, n - 1, board);
        }
        for(int i = 1; i< m-1;i++){
            for(int j = 1; j< n-1;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        for(int i = 0; i< m;i++){
            for(int j = 0; j< n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        

    }

    public void dfs(int r, int c, char[][] board) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        dfs(r + 1, c, board);
        dfs(r, c + 1, board);
        dfs(r - 1, c, board);
        dfs(r, c - 1, board);
    }

 
}