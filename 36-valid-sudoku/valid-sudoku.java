class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowWiseMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colWiseMap = new HashMap<>();
        HashMap<List<Integer>, HashSet<Character>> squareWiseMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rowWiseMap.put(i, new HashSet<>());
            colWiseMap.put(i, new HashSet<>());
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                List<Integer> squareCoord = new ArrayList<>();
                squareCoord.add(r / 3);
                squareCoord.add(c / 3);
                if (!squareWiseMap.containsKey(squareCoord)) {
                    squareWiseMap.put(squareCoord, new HashSet<>());
                }

                if (rowWiseMap.get(r).contains(board[r][c]) ||
                        colWiseMap.get(c).contains(board[r][c]) ||
                        squareWiseMap.get(squareCoord).contains(board[r][c])) {
                    return false;
                } else {
                    rowWiseMap.get(r).add(board[r][c]);
                    colWiseMap.get(c).add(board[r][c]);
                    squareWiseMap.get(squareCoord).add(board[r][c]);
                }

            }
        }
        return true;
    }
}