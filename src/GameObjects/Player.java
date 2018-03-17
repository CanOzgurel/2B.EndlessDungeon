package GameObjects;

public class Player extends GameObject {

	private int health;
	private int attack;
	private int defense;
//	private PlayerType type;

	public Player(){
		health = 100; //default health
		attack = 0;
		defense = 0;
	}

	public Player(int health, int attack, int defense){
		health = health;
		attack = attack;
		defense = defense;
	}

//	public void useSkill() {
//		// TODO - implement Player.useSkill
//		throw new UnsupportedOperationException();
//	}

//	public void UseItem() {
//		// TODO - implement Player.UseItem
//		throw new UnsupportedOperationException();
//	}


	public int getHealth(){
		return health;
	}

	public void setHealth(int newHealth){
		health = newHealth;
	}

	public int getAttack(){
		return attack;
	}

	public void setAttack(int newAttack){
		attack = newAttack;
	}

	public int getDefense(){
		return defense;
	}

	public void setDefense(int newDefense){
		defense = newDefense;
	}

	public boolean isAlive() {
		if(health > 0)
			return true;
		else
			return false;
	}

//	public PlayerType getPlayerType(){
//		return type;
//	}
//
//	public void setPlayerType(PlayerType newType){
//		type = newType;
//	}



}