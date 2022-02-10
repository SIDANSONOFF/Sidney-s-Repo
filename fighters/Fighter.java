package fighters;

public abstract class Fighter {
    protected int currentHP;

    public Fighter(int maxHealth){
        this.currentHP = maxHealth;
    }

    protected boolean isUnconscious(){
        if (currentHP <= 0){
            currentHP = 0;
            return true;
        }
        return false;
    }

    public abstract void printHealth();
    public abstract int attack();
    public abstract void takeDamage(int damage);
}
