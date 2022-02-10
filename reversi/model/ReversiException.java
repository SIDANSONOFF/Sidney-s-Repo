package reversi.model;

/**
 * An exception indicating that a player attempted to make a bad move.
 */
public class ReversiException extends Exception {
    /**
     * Creates a new {@link ReversiException} with the specified informative
     * message.
     *
     * @param message The informative message.
     */
    public ReversiException(String message) {
        super(message);
    }
}
