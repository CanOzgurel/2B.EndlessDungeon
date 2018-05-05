public class Skill {
    private double damage;
    private String name;
    private String type; //melee, fire or frost

    public Skill(String name, double damage, String type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public double getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getType( ) {
        return type;
    }

}