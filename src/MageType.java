public class MageType extends PlayerType{

    private int extraHealth;
    private int extraAttack;
    private int extraArmor;


    public MageType()
    {
        super("Mage", 0,10,20);

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
