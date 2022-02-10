package memory.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RestartGame implements EventHandler<ActionEvent>{
    private final MemoryGUI memory;


    public RestartGame(MemoryGUI memory){
        this.memory = memory;
    }

    @Override
    public void handle(ActionEvent arg0) {
        // TODO Auto-generated method stub
        try {
            memory.start(MemoryGUI.STAGE);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
