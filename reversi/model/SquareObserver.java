package reversi.model;

/**
 * Interface implemented by a class that wishes to be notified whenever a
 * specific square on the Reversi board changes.
 */
public interface SquareObserver {
    /**
     * Called when the state of the subject (a square) is changed. This may 
     * happen when the square is reset, a piece is played, or a piece is 
     * flipped.
     * 
     * @param square The square that has changed.
     */
    public void squareChanged(Square square);
}
