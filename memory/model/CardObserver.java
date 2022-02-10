package memory.model;
/**
 * Implemented by any class that wants to know if a card has changed
 */
public interface CardObserver {

    /**
     * Called when a card is changed
     * @param card The card that is changed
     */
    public abstract void cardChanged();
}
