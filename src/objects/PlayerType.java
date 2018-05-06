package objects;

public class PlayerType {


    private int extraHealth;
    private int extraAttack;
    private int extraArmor;

    public PlayerType(int extraHealth, int extraAttack, int extraArmor)
    {
        this.extraHealth = extraHealth;
        this.extraAttack = extraAttack;
        this.extraArmor = extraArmor;
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
