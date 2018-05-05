public class Player {
    private float health, maxHealth, damage, armor;

    public Player(float health, float maxHealth, float damage, float armor) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.armor = armor;
    }

    public void update() {

    }

    public void attack(Enemy enemy) {
        float damageDealt = this.damage - enemy.getArmor();

        if (damageDealt > 0) {
            enemy.setHealth(enemy.getHealth() - damageDealt);
        }
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }
}
