package GameObjects;

public class GameObject {

	protected int type; //1: player 2: enemy
	protected String name;

	public GameObject() {
		type = 0;
		name = "";
	}

	public String getType(){
		if(type==1)
			return "Player";
		else
			return "Enemy";
	}

	public void setType(int newType){
		type = newType;
	}

	public String getName(){
		return name;
	}

	public void setName(String newName){
		name = newName;
	}

	public void updateObject(int i) {
		if(type == 1) {
			((Player)this).setHealth(((Player)this).getHealth() + i);
		}
		else if(type == 2){
			((Enemy)this).setHealth(((Enemy)this).getHealth() + i);

		}
	}


}