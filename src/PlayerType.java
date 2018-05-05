public class PlayerType {

	private String type;
    private int extraHealth;
    private int extraAttack;
    private int extraArmor;

    public PlayerType(String type, int extraHealth, int extraAttack, int extraArmor)
    {
    	this.type = type;
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
    
    public String getType() {
    	return type;
    }
}
