package fighters;
import java.util.Random;

public class MuleMonkey extends Fighter {
    private final Random Random = new Random();

    public MuleMonkey(){
        super(200);
    }

    public int attack(){
        int num = Random.nextInt(100);
        if (!(num < 25)) {
            return 75;
        }
        else{
            return 0;
        }
    }

    public void takeDamage(int damage){
        if (currentHP < 50){
            damage -= 10;
            currentHP -= damage;
        }
        else{
            currentHP -= damage;
        }
    }


    public void printHealth(){
        System.out.println("Mule Monkey Current Health: " + currentHP);
    }

    @Override
    public String toString(){
        return "Mule Monkey wins!";
    }
}
