package objects;

public class AssassinType  extends PlayerType {


    private int extraHealth;
    private int extraAttack;
    private int extraArmor;

    public AssassinType()
    {
        super(0,20,10);

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