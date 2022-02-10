package fighters;
import java.util.Random;

public class Lonk extends Fighter {
    private final Random Random = new Random();

    public Lonk(){
        super(150);
    }

    public int attack(){
        return 45;
    }

    public void takeDamage(int damage){
        int num = Random.nextInt(100);
        if (num < 50){
            currentHP -= damage/2;
        }
        else{
            currentHP -= damage;
        }
    }

    
    public void printHealth(){
        System.out.println("Lonk Current Health: " + currentHP);
    }

    @Override
    public String toString(){
        return "Lonk wins!";
    }
}
