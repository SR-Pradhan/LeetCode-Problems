class Solution {

    public String tictactoe(int[][] moves) {

        char[][] board = new char[3][3];

        // Fill the board
        for (int i = 0; i < moves.length; i++) {

            int row = moves[i][0];
            int col = moves[i][1];

            if (i % 2 == 0) {
                board[row][col] = 'A';
            } else {
                board[row][col] = 'B';
            }
        }

        // Check winner
        if (hasWon(board, 'A')) {
            return "A";
        }

        if (hasWon(board, 'B')) {
            return "B";
        }

        // If 9 moves have been played, board is full
        if (moves.length == 9) {
            return "Draw";
        }

        return "Pending";
    }

    private boolean hasWon(char[][] board, char player) {

        // Check rows
        for (int i = 0; i < 3; i++) {

            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {

                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {

            if (board[0][j] == player &&
                board[1][j] == player &&
                board[2][j] == player) {

                return true;
            }
        }

        // Main diagonal
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {

            return true;
        }

        // Other diagonal
        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {

            return true;
        }

        return false;
    }
}