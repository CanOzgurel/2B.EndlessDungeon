public class Skill {
    private double damage, manaReq;
    private String name;
    private String type; //melee, fire or frost

    public Skill(String name, double damage, double manaReq, String type) {
        this.name = name;
        this.damage = damage;
        this.manaReq = manaReq;
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

    public double getManaReq() { return manaReq; }

}