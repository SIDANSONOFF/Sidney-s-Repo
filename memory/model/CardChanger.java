package memory.model;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import memory.view.MemoryGUI;

public class CardChanger implements CardObserver {
    private final Card card;
    private final int row;
    private final int col;
    public static final ImageView CARD_BACK = new ImageView("file:media/images/memory/back.png");
    public ImageView CARD_BLANK = new ImageView("file:media/images/memory/wood.png");

    /**
     * CardChanger constructor
     * @param card specific card
     * @param row row of card
     * @param col column of card
     */
    public CardChanger(Card card, int row, int col){
        this.card = card;
        this.row = row;
        this.col = col;
    }

    /**
     * Changes card to face up
     * Shows Symbol Side
     */
    @Override
    public void cardChanged() {
        // Gets specific button in the pane
        Button button = (Button) getNodeByRowColumnIndex(row, col, MemoryGUI.pane);

        if ((card.isFaceUp())){
            button.setGraphic(card.getSymbol().getPicture());
        }
    }

    /**
     * Changes card to face down
     * Shows Back
     */
    public void cardBack() {
        if (!(card.equals(new Card()))) {
        // Finds specific button in pane
        Button button = (Button) getNodeByRowColumnIndex(row, col, MemoryGUI.pane);

        button.setGraphic(CARD_BACK);
        }
    }

    /**
     * Gets rid of card
     * Shows background
     */
    public void cardBlank() {
        Button button = (Button) getNodeByRowColumnIndex(row, col, MemoryGUI.pane);
        button.setGraphic(CARD_BLANK);
    }

    /**
     * Finds node based on its row and column
     * @param row
     * @param column
     * @param gridPane 
     * @return node at the row and column specified
     */
    public static Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();
    
        for (Node node : childrens) {
            if(GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
    
        return result;
    }
    
}
