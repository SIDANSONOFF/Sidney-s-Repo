package memory.view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import memory.model.CardTypes;
import memory.model.Memory;
import memory.model.MemoryException;

public class MemoryGUI extends Application {
    // Back of card image
    public static final Image CARD_BACK = new Image("file:media/images/memory/back.png");

    private static final int ROWS = 4;
    private static final int COLS = 4;

    //Label Names and values
    public static Label SCORE;
    public static int score;
    public static Label MOVES;
    public static int moves;
    public static Label TEXT;
    public static Button RESTART;
    
    public final CardTypes[] symbols = {CardTypes.CARD1, CardTypes.CARD2, CardTypes.CARD3, CardTypes.CARD4, CardTypes.CARD5, CardTypes.CARD6, CardTypes.CARD7, CardTypes.CARD8,};
    private Memory board;
    public static GridPane pane;
    public static Stage STAGE;

    public MemoryGUI(){

    }

    /**
     * Runs GUI
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Stores stage in public static variable
        STAGE = stage;

        // Creates board
        board = new Memory(4, 4, symbols);

        // Makes Score title
        Label ScoreTitle = new Label("SCORE");
        ScoreTitle.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        ScoreTitle.setFont(new Font("Comic Sans", 28));
        ScoreTitle.setPadding(new Insets(45));
        ScoreTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Makes Moves title
        Label MoveTitle = new Label("MOVES");
        MoveTitle.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        MoveTitle.setFont(new Font("Comic Sans", 28));
        MoveTitle.setPadding(new Insets(45));
        MoveTitle.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Makes Restart Button
        RESTART = new Button("RESTART");
        RESTART.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        RESTART.setFont(new Font("Comic Sans", 20));
        RESTART.setPadding(new Insets(60));
        RESTART.setOnAction(new RestartGame(this));
        RESTART.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Makes GridPane of the cards
        pane = new GridPane();
        for(int r=0; r<ROWS; r++){
            for(int c=0; c<COLS; c++){
                pane.add(makeCard(r, c), r, c);
            }
        }

        // Makes score counter
        SCORE = new Label("00");
        SCORE.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        SCORE.setFont(new Font("Comic Sans", 50));
        SCORE.setPadding(new Insets(40));
        SCORE.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Makes moves counter
        MOVES = new Label("00");
        MOVES.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        MOVES.setFont(new Font("Comic Sans", 50));
        MOVES.setPadding(new Insets(40));
        MOVES.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // Makes text box
        TEXT = new Label("Make your first move");
        TEXT.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        TEXT.setFont(new Font("Comic Sans", 30));
        TEXT.setPadding(new Insets(40));
        TEXT.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        
        // Creates GUI through boxes
        VBox box = new VBox();
        box.getChildren().addAll(ScoreTitle, SCORE, MoveTitle, MOVES);
        HBox box2 = new HBox();
        box2.getChildren().addAll(box, pane);
        VBox box3 = new VBox();
        box3.getChildren().addAll(box2, TEXT, RESTART);

        // Sets Stage
        stage.setTitle("Memory Game");
        stage.setScene(new Scene(box3));
        stage.show();

    }

    /**
     * Makes a card and set an actions based on the row and column
     * @param row index of row
     * @param col index of column
     * @return returns the made button
     */
    private Button makeCard(int row, int col){
        ImageView BACK = new ImageView(CARD_BACK);
        Button button = new Button("", BACK);
        button.setPrefSize(100, 100);
        button.setBackground(new Background(new BackgroundImage(CARD_BACK, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        button.setPadding(new Insets(0));
        button.setOnAction(new MoveMaker(row, col, this));

        return button;
    }

    /**
     * Makes move
     * @param row
     * @param col
     */
    void makeMove(int row, int col){
        try{
            board.flip(row, col);
            TEXT.setText("Good move!");
        }
        catch(MemoryException me){
            TEXT.setText(me.getMessage());
        }
    }
    public static void main(String[] args){
        launch(args);
    }

}
