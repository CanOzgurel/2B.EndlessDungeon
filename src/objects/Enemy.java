package objects;

import ui.MainMenu;

import java.awt.*;

/**
 * class Enemy
 * The main opposition of the player in Endless Dungeon
 */
public class Enemy {
    protected double health, maxHealth, damage, armor;
    protected int width, height, side, x, y;
    private int bossType; // Between 0-4, 0: Basic enemy, 1: Fire boss, 2: Frost boss, 3-4: Regular boss
    private Image img;
    private final int MARGIN = 70;
    private boolean isClicked = false;

    public Enemy(double health, double maxHealth, double damage, double armor, int width, int height, int side, int bossType, Image img) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.armor = armor;
        this.width = width;
        this.height = height;
        this.side = side;
        this.bossType = bossType;
        this.img = img;

        if (side == 1) {
            x = MARGIN -20 ;
            y = MainMenu.HEIGHT / 2 - height / 3;
        }
        else {
            x = MainMenu.WIDTH - MARGIN - width + 20;
            y = MainMenu.HEIGHT / 2 - height / 3;
        }

    }

    public void update() {

    }

    // Renders the visual elements of the enemy
    public void render(Graphics2D g) {
        if (health > 0) {
            if (isClicked) {
                g.setColor(Color.GREEN);

                float thickness = 3;

                Stroke oldStroke = g.getStroke();
                g.setStroke(new BasicStroke(thickness));

                g.drawRect(x - 5, y - 5, width + 10, height + 10);

                g.setStroke(oldStroke);
            }
            renderHealthBar(g);
            renderType(g);

            g.setColor(Color.BLACK);
            g.drawImage(img, x, y, width, height, null);
        }

    }

    // Helper function for rendering the health bar
    public void renderHealthBar(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.drawRect(x + 10, y - 30, width - 20, 10);

        Font newFont = new Font ("Courier New", Font.BOLD , 15);
        g.setFont(newFont);
        g.setColor(Color.LIGHT_GRAY);
        g.drawString("Health: " + health, x+10, y-80);
        g.drawString("Damage: " + damage, x+10, y-60);
        g.drawString("Armor: " + armor, x+10, y-40);

        if (health <= 20) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(Color.GREEN);
        }

        g.fillRect(x + 11, y - 29, (int)((health / maxHealth) * (width - 21)), 9 );
    }

    // Helper function for rendering the type of the enemy
    public void renderType(Graphics2D g) {
        if(bossType == 1) {
            Font newFont2 = new Font ("Bookman Old Style", Font.PLAIN, 30);
            g.setFont(newFont2);
            g.setColor(Color.RED);
            g.drawString("FIRE", x+200, y-40);
        }
        else if(bossType == 2) {
            Font newFont2 = new Font ("Bookman Old Style", Font.PLAIN, 30);
            g.setFont(newFont2);
            g.setColor(Color.CYAN);
            g.drawString("FROST", x+200, y-40);
        }

    }

    // Checks whether the enemy has been clicked or not
    public void clicked(int x, int y) {
        Rectangle rect = new Rectangle(this.x, this.y, width, height);

        if (rect.contains(new Point(x, y))) {
            isClicked = true;
        }
        else {
            isClicked = false;
        }
    }

    // Attacks the given player object (only one player exists in Endless Dungeon)
    public void attack(Player player) {
        double damageDealt = this.damage - player.getArmor();

        if (damageDealt > 0) {
            player.setHealth(player.getHealth() - damageDealt);
        }
    }

    public boolean isClicked() {
        return isClicked;
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getType() {
        return bossType;
    }
}