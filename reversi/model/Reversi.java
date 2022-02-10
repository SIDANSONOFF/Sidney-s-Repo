package reversi.model;

import java.util.*;

/**
 * A class to represent a Reversi board. Includes all of the logic for making
 * and validating moves as well as which player is currently taking a turn.
 */
public class Reversi {
    /**
     * The number of rows on the board.
     */
    public static final int ROWS = 8;

    /**
     * The number of columns on the board.
     */
    public static final int COLS = 8;

    /**
     * The two-dimensional array of {@link Square squares} that comprise the
     * board.
     */
    private Square[][] board;

    /**
     * The {@link Color} of the current player.
     */
    private Color turn;

    /**
     * Creates a new, empty Reversi board.
     */
    public Reversi() {
        board = new Square[ROWS][COLS];
        for(int row=0; row<ROWS; row++) {
            for(int col=0; col<COLS; col++) {
                board[row][col] = new Square();
            }
        }
        start();
    }

    /**
     * Starts a new game by resetting all of the {@link Square squares} on the
     * board and playing 4 pieces in the center of the board (two of each
     * color).
     */
    public void start() {
        for(Square[] row : board) {
            for(Square square : row) {
                square.reset();
            }
        }

        turn = Color.BLACK;

        try {
            // black and white pieces played in center
            board[3][3].occupy(Color.BLACK);
            board[3][4].occupy(Color.WHITE);
            board[4][3].occupy(Color.WHITE);
            board[4][4].occupy(Color.BLACK);
        } catch(ReversiException ime) {
            // squash
        }
    }

    /**
     * Attempts to play a piece of the current player's {@link Color} on the
     * square at the specified row and column on the board.
     *
     * @param row The row on which the player would like to play a piece.
     * @param col The column on which the player would like to play a piece.
     * @throws ReversiException If the move is invalid.
     */
    public void move(int row, int col) throws ReversiException {
        if(row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            throw new ReversiException("Invalid coordinates: (" + row + ", " 
                + col + ")");
        }

        Collection<Square> toFlip = searchAll(row, col);

        if(toFlip.size() == 0) {
            throw new ReversiException(
                "Move must flip at least one opponent piece.");
        }

        board[row][col].occupy(turn);        

        for(Square square : toFlip) {
            square.flip();
        }
        turn = turn.flip();
    }

    /**
     * Passes the turn to the next player.
     */
    public void pass() {
        turn = turn.flip();
    }

    /**
     * Returns the {@link Color} of the current player.
     *
     * @return The {@link Color} of the current player.
     */
    public Color getCurrentPlayer() {
        return turn;
    }

    public Square getSquare(int row, int col) {
        return board[row][col];
    }

    /**
     * Returns all of the squares that should potentially be flipped after the
     * current player plays a piece at the specified location.
     *
     * @param row The row of the play.
     * @param col The column of the play.
     *
     * @return The collection of all squares that should be flipped after the
     * play.
     */
    private Collection<Square> searchAll(int row, int col) {
        Collection<Square> squares = new HashSet<>();
        squares.addAll(searchDir(row, col, Direction.TOP));
        squares.addAll(searchDir(row, col, Direction.TOP_RIGHT));
        squares.addAll(searchDir(row, col, Direction.RIGHT));
        squares.addAll(searchDir(row, col, Direction.BOTTOM_RIGHT));
        squares.addAll(searchDir(row, col, Direction.BOTTOM));
        squares.addAll(searchDir(row, col, Direction.BOTTOM_LEFT));
        squares.addAll(searchDir(row, col, Direction.LEFT));
        squares.addAll(searchDir(row, col, Direction.TOP_LEFT));
        return squares;
    }

    /**
     * Searches in the given direction.
     *
     * @param row The row at which the search starts.
     * @param col The column at which the search starts.
     * @param d The direction of the search.
     * @return The list of opposing pieces.
     */
    private List<Square> searchDir(int row, int col, Direction d ) {
        List<Square> squares = new ArrayList<>();
        for(int r=row+d.getRowMod(), c=col+d.getColMod();
            r>=0 && r<ROWS && c>=0 && c<COLS;
            r=r+d.getRowMod(), c=c+d.getColMod()) {

            Square square = board[r][c];
            Color color = square.getOccupyingColor();
            if (color == Color.EMPTY) {
                squares.clear();
                return squares;
            } else if (color == getCurrentPlayer()) {
                // found an enclosing square!
                return squares;
            } else {
                // add this to the list of potential squares
                squares.add(square);
            }
        }
        // did not find an enclosing square
        squares.clear();
        return squares;
    }
}
