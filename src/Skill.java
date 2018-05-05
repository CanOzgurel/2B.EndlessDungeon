
public class Skill {
	private double damage;
	private String name;
	
	public Skill(String name, double damage) {
		this.name = name;
		this.damage = damage;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public String getName() {
		return name;
	}

}
