import java.awt.*;

public class Enemy {
    protected float health, maxHealth, damage, armor;
    protected int width, height, side, x, y;
    private Image img;
    private final int MARGIN = 70;
    private boolean isClicked = false;

    public Enemy(float health, float maxHealth, float damage, float armor, int width, int height, int side, Image img) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.armor = armor;
        this.width = width;
        this.height = height;
        this.side = side;
        this.img = img;

        if (side == 1) {
            x = MARGIN;
            y = GameFrame.HEIGHT / 2 - height / 3;
        }
        else {
            x = GameFrame.WIDTH - MARGIN - width;
            y = GameFrame.HEIGHT / 2 - height / 3;
        }

    }

    public void update() {

    }

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

            g.setColor(Color.BLACK);
            g.drawImage(img, x, y, width, height, null);
        }
    }

    public void renderHealthBar(Graphics2D g) {
        g.setColor(Color.GRAY);
        g.drawRect(x + 10, y - 30, width - 20, 10);

        if (health <= 20) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(Color.GREEN);
        }

        g.fillRect(x + 11, y - 29, (int)((health / maxHealth) * (width - 21)), 9 );
    }

    public void clicked(int x, int y) {
        Rectangle rect = new Rectangle(this.x, this.y, width, height);

        if (rect.contains(new Point(x, y))) {
            isClicked = true;
        }
        else {
            isClicked = false;
        }
    }

    public void attack(Player player) {
        float damageDealt = this.damage - player.getArmor();

        if (damageDealt > 0) {
            player.setHealth(player.getHealth() - damageDealt);
        }
    }

    public boolean isClicked() {
        return isClicked;
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
