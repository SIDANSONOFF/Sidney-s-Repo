package reversi.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveMaker implements EventHandler<ActionEvent>{
    private final int row;
    private final int col;
    private final ReversiGUI reversi;

    public MoveMaker(int row, int col, ReversiGUI reversi){
        this.row = row;
        this.col = col;
        this.reversi = reversi;
    }

    @Override
    public void handle(ActionEvent event){
        reversi.makeMove(row, col);
    }
}
