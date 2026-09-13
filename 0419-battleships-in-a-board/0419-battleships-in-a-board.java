class Solution {
    public int countBattleships(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X') {

                    // If there is an X above or to the left,
                    // this cell is part of an existing battleship.
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }

                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }

                    // Otherwise, this is the starting cell.
                    count++;
                }
            }
        }

        return count;
    }
}