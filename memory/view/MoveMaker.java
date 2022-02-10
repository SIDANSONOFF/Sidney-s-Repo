package memory.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveMaker implements EventHandler<ActionEvent>{
    private final int row;
    private final int col;
    private final MemoryGUI memory;

    /**
     * MoveMaker constructor
     * @param row
     * @param col
     * @param memory
     */
    public MoveMaker(int row, int col, MemoryGUI memory){
        this.row = row;
        this.col = col;
        this.memory = memory;
    }

    /**
     * Calls makeMove to handle a button being pressed
     */
    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub
        memory.makeMove(row, col);
    }
    
}
