package fighters;
import java.util.Random;

public class Samosa extends Fighter {
    private final Random Random = new Random();

    public Samosa(){
        super(200);
    }

    public int attack(){
        int num = Random.nextInt(100);
        if (!(num < 25)) {
            return 40;
        }
        else{
            return 75;
        }
    }

    public void takeDamage(int damage){
        currentHP -= damage;
    }

    public void printHealth(){
        System.out.println("Samosa Current Health: " + currentHP);
    }

    @Override
    public String toString(){
        return "Samosa wins!";
    }
}
