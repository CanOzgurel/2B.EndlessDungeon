import java.awt.*;

public class BossEnemy extends Enemy {

    public BossEnemy(float health, float maxHealth, float damage, float armor, int width, int height, Image img) {
        super(health, maxHealth, damage, armor, width, height, 0, img);
        x = GameFrame.WIDTH / 2 - width / 2;
        y = GameFrame.HEIGHT / 2 - height / 2;
    }

    @Override
    public void update() {

    }
}
