public class TicTacToe {
    int[] rows;

    int[] cols;
    int[] diag;
    /**
     * The size (number of rows/columns) of the tic-tac-toe board.
     */
    private int boardSize;
    public TicTacToe(int boardSize) {
        this.boardSize = boardSize;
         rows = new int[boardSize];

        cols= new int[boardSize];
        diag = new int[2];

    }
    /**
     * Records a player with the given ID making a move at the given x and y
     * coordinates. The top left square is at coordinates (0,0).
     *
     * @param playerId The ID of the player making the move
     * @param x
    The X coordinate of the move
     * @param y
     *
    The Y coordinate of the move
     * @return True if the move results in the player winning the game,
     *
    false otherwise.
     *
     * @throws InvalidMoveException If the move is invalid for any reason
     */
    public boolean move(int playerId, int x, int y) throws InvalidMoveException {

        int playerMove = playerId == 1 ? 1 : -1;

        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
            throw new InvalidMoveException();
        }

        if(rows[x] != 0 || cols[y] != 0 ) {
            throw new InvalidMoveException();
        }

       rows[x] += playerMove;
       cols[y] += playerMove;

       if (x == y) {
           diag[0] += playerMove;
       }
       if (x + y == boardSize - 1) {
           diag[1] += playerMove;
       }

        return Math.abs(rows[x]) == boardSize || Math.abs(cols[y]) == boardSize || Math.abs(diag[0]) == boardSize || Math.abs(diag[1]) == boardSize;
    }
}

class InvalidMoveException extends Exception {

}
