import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] boxsets = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            boxsets[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i++) {
            var rowSet = new HashSet<Character>();
            var colSet = new HashSet<Character>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    } else {
                        colSet.add(board[j][i]);
                    }
                }
                 if (board[i][j] != '.') {
                    var boxNum = (i / 3) * 3 + (j / 3);
                    var setAtBoxNum = boxsets[boxNum];
                    if(setAtBoxNum.contains(board[i][j])){
                        return false;
                    }
                    else{
                        setAtBoxNum.add(board[i][j]);
                    }
                 }
            }
        }
        return true;
    }
}
