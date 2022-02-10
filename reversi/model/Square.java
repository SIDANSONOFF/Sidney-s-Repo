package reversi.model;

import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a square on a board in a game of Reversi.
 */
public class Square {
    // ADDITIONAL CODE ADDED DURING CLASS. REMOVE FROM PROVIDED CODE
    private Set<SquareObserver> observers;

    public void register(SquareObserver observer) {
        observers.add(observer);
    }

    private final void notifyObservers() {
        for(SquareObserver observer : observers) {
            observer.squareChanged(this);
        }
    }
    // ADDITIONAL CODE ADDED DURING CLASS. REMOVE FROM PROVIDED CODE


    /**
     * The piece that may or may not occupy the square.
     */
    private Color piece;

    /**
     * Creates a new, empty square.
     */
    public Square() {
        piece = Color.EMPTY;

        observers = new HashSet<>();
    }

    /**
     * Returns true if the square has a piece played on it, and false
     * otherwise.
     *
     * @return True if a piece has been played on the square. Otherwise false.
     */
    public boolean isOccupied() {
        return piece != Color.EMPTY;
    }

    /**
     * Returns the currently face-up color of the piece on this square (or
     * Color.EMPTY if there is no piece).
     *
     * @return The currently face-up color of the piece on this square.
     */
    public Color getOccupyingColor() {
        return piece;
    }

    /**
     * Attempts to play a piece on the square.
     *
     * @param piece The piece being played on the square.
     *
     * @throws ReversiException If a piece has already been played on the
     * square.
     */
    public void occupy(Color piece) throws ReversiException {
        if(isOccupied()) {
            throw new ReversiException("Square is already occupied");
        } else {
            this.piece = piece;
            notifyObservers();
        }
    }

    /**
     * Resets the square to the empty state (no piece played).
     */
    public void reset() {
        piece = Color.EMPTY;
    }

    /**
     * Flips the piece played on this square to the opposite side.
     *
     * @throws ReversiException If the square is empty.
     */
    public void flip() throws ReversiException {
        if(!isOccupied()) {
            throw new ReversiException("Square is empty.");
        } else {
            piece = piece.flip();
            notifyObservers();
        }
    }

    /**
     * Returns a string representation of the square; either " " if the square
     * is empty, or the short symbol for the piece if it is not.
     *
     * @return A string representation of the square.
     */
    @Override
    public String toString() {
        return isOccupied() ? piece.getSymbol() : " ";
    }
}
