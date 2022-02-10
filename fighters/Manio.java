package fighters;
import java.util.Random;

public class Manio extends Fighter{
    private final Random Random = new Random();

    public Manio(){
        super(100);
    }

    public int attack(){
        int num = Random.nextInt(26);
        return (num + 25);
    }

    public void takeDamage(int damage){
        int num = Random.nextInt(100);
        if (!(num < 25)) {
            currentHP -= damage;
        }
    }

    public void printHealth(){
        System.out.println("Manio Current Health: " + currentHP);
    }

    @Override
    public String toString(){
        return "Manio wins!";
    }
}
