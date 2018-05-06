package objects;

public class Item {

    private int item, extraHealth, extraDamage, extraArmor;
    private String name;

    public Item( int item, int extraHealth, int extraDamage, int extraArmor, String name)
    {
        this.item = item;
        this.name = name;
        this.extraHealth = extraHealth;
        this.extraDamage = extraDamage;
        this.extraArmor = extraArmor;
    }

    public int getItem()
    {
        return item;
    }

    public void setItem(int item) {
        item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtraHealth() {
        return extraHealth;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public int getExtraArmor() {
        return extraArmor;
    }

}