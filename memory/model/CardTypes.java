package memory.model;

import javafx.scene.image.ImageView;

public enum CardTypes {
    CARD1(new ImageView("file:media/images/memory/goat00.png")),
    CARD2(new ImageView("file:media/images/memory/goat01.png")),
    CARD3(new ImageView("file:media/images/memory/goat02.png")),
    CARD4(new ImageView("file:media/images/memory/goat03.png")),
    CARD5(new ImageView("file:media/images/memory/goat04.png")),
    CARD6(new ImageView("file:media/images/memory/goat05.png")),
    CARD7(new ImageView("file:media/images/memory/goat06.png")),
    CARD8(new ImageView("file:media/images/memory/goat07.png"));

    private final ImageView type;

    private CardTypes(ImageView type){
        this.type=type;
    }

    public ImageView getPicture(){
        return type;
    }
}
