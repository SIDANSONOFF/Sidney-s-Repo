package fighters;

public class arena {

    public static void battle(Fighter fighter1, Fighter fighter2){
        boolean ongoing = true;
        while (ongoing) {
        fighter2.takeDamage(fighter1.attack());
        fighter1.takeDamage(fighter2.attack());

        if (fighter1.isUnconscious() && fighter2.isUnconscious()){
            System.out.println("Its a Draw!");
            ongoing = false;
        }
        else if(fighter1.isUnconscious()){
            System.out.println(fighter2);
            ongoing = false;
        }
        else if(fighter2.isUnconscious()){
            System.out.println(fighter1);
            ongoing = false;
        }
        else{
            fighter1.printHealth();
            fighter2.printHealth();
            System.out.println();
        }
    }
    }

    public static void main(String[] args){
        battle(new Lonk(), new Manio());
    }
    
}
