package GameObjects;

public class Enemy extends GameObject {

	private int health;
	private int attack;
	private int defense;
//	private EnemyType type;
	//private Image image;

	public Enemy(){
		health = 100; //default health
//		type = new RegularType(); //default type
	}

	public Enemy(int health, int attack, int defense) {
		health = health;
		attack = attack;
		defense = defense;
//		type = type;
	}

	public boolean isAlive() {
		if(health > 0)
			return true;
		else
			return false;
	}

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

//	public void drawEnemy() {
//		// TODO - implement Enemy.drawEnemy
//		throw new UnsupportedOperationException();
//	}

}