import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Player {
    private double health, maxHealth, damage, armor;
    private int level;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Image imgPlate, imgSword, imgScroll;

    public Player(double health, double maxHealth, double damage, double armor, int level, ArrayList<Skill> skills, ArrayList<Item> inventory) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.armor = armor;
        this.level = level;
        this.skills = skills;
        this.inventory = inventory;
        this.imgPlate = new ImageIcon("src/res/platemail.jpg").getImage();
        this.imgSword = new ImageIcon("src/res/sword.jpg").getImage();
        this.imgScroll = new ImageIcon("src/res/scroll.jpg").getImage();

    }

    public void update() {

    }

    public void attack(Enemy enemy, int n) {
        double damageDealt;
        if (n == 0)
            damageDealt = this.damage - enemy.getArmor();

        else {
            if(enemy.getType() == 1 && this.skills.get(n-1).getType().equals("Frost") ) {
                damageDealt = (this.skills.get(n-1).getDamage())*2 - enemy.getArmor();
            }
            else if(enemy.getType() == 2 && this.skills.get(n-1).getType().equals("Fire") ) {
                damageDealt = (this.skills.get(n-1).getDamage())*2 - enemy.getArmor();
            }
            else
                damageDealt = this.skills.get(n-1).getDamage() - enemy.getArmor();
        }

        enemy.setHealth((int)enemy.getHealth() - damageDealt);
    }

    public void renderInventory(Graphics2D g){
        if(inventory.get(0) != null)
            g.drawImage(imgPlate, 25, 25, null );
        if(inventory.get(1) != null)
            g.drawImage(imgSword, 70, 25, null );
        if(inventory.get(2) != null)
            g.drawImage(imgScroll, 115, 25, null );


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

    public ArrayList<Item> getInventory(){
        return inventory;
    }

    public void addItem(Item item){
        inventory.add(item);
    }


}