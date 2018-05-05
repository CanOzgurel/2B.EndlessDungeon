import java.util.ArrayList;

public class Player {
    private double health, maxHealth, damage, armor;
    private int level;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    
    public Player(double health, double maxHealth, double damage, double armor, int level, ArrayList<Skill> skills) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.armor = armor;
        this.level = level;
//        this.type = type; //1: warrior 2: rogue 3: mage
        this.skills = skills;
    }

    public void update() {

    }

    public void attack(Enemy enemy, int n) {
    	double damageDealt;
    	if (n == 0)
    		damageDealt = this.damage - enemy.getArmor();
    	
    	else
    		damageDealt = this.skills.get(n-1).getDamage() - enemy.getArmor();
    	
            enemy.setHealth((int)enemy.getHealth() - damageDealt);
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public void setLevel(int level) {
    	this.level = level;
    }
    
//    public PlayerType getPlayerType() {
//    	return type;
//    }
//    
//    public void setType( int type) { //1 for Warrior, 2 for Assassin, 3 for Mage
//    	switch(type) {
//    	case 1: this.type = new WarriorType();
//    			break;
//    	case 2: this.type = new AssassinType();
//    			break;
//    	case 3: this.type = new MageType();
//    			break;
//    	default: this.type = new WarriorType();
//				 break;
//    	}
//    }
    
}
