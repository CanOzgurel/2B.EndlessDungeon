public class WarriorType  extends PlayerType{

    private int extraHealth;
    private int extraAttack;
    private int extraArmor;


    public WarriorType()
    {
        super("Warrior", 15,15,5);

    }

    public int getExtraAttack() {
        return extraAttack;
    }

    public int getExtraHealth(){
        return extraHealth;
    }

    public int getExtraArmor()
    {
        return  extraArmor;
    }
}