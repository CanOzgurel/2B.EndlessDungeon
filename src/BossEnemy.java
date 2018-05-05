import java.awt.*;

public class BossEnemy extends Enemy {

    public BossEnemy(double health, double maxHealth, double damage, double armor, int width, int height, int type, Image img) {
        super(health, maxHealth, damage, armor, width, height, 0, type, img);
        x = GameFrame.WIDTH / 2 - width / 2;
        y = GameFrame.HEIGHT / 2 - height / 2;
    }

    @Override
    public void update() {

    }
}
