import javax.swing.*;
import java.awt.*;

public class ObjectHandler {
    private static ObjectHandler instance = new ObjectHandler();
    private Enemy enemyLeft, enemyRight;
    private BossEnemy enemyBoss;
    private Player player;
    private Image imgEnemyLeft, imgEnemyRight, imgEnemyBoss;

    private ObjectHandler() {
        imgEnemyLeft = new ImageIcon("src/res/enemy_basic_1.png").getImage();
        imgEnemyRight = new ImageIcon("src/res/enemy_basic_2.png").getImage();
        imgEnemyBoss = new ImageIcon("src/res/enemy_boss_1.png").getImage();

        enemyLeft = new Enemy(100, 100, 10, 2, 150, 200, 1, imgEnemyLeft);
        enemyRight = new Enemy(100, 100, 10, 2, 150, 200, 2, imgEnemyRight);
        enemyBoss = new BossEnemy(200, 200, 15, 5, 300, 400, imgEnemyBoss);
        player = new Player(500, 500, 50, 8);
    }

    public void update() {
        enemyLeft.update();
        enemyRight.update();
        enemyBoss.update();
        player.update();
    }

    public void render(Graphics2D g) {
        enemyLeft.render(g);
        enemyRight.render(g);
        enemyBoss.render(g);
    }

    public static ObjectHandler getInstance() {
        return instance;
    }

    public Enemy getClickedEnemy() {
        if (enemyLeft.isClicked()) {
            return enemyLeft;
        }
        else if (enemyRight.isClicked()) {
            return enemyRight;
        }
        else if (enemyBoss.isClicked()) {
            return enemyBoss;
        }
        else {
            return null;
        }
    }

    public Enemy getEnemyLeft() {
        return enemyLeft;
    }

    public void setEnemyLeft(Enemy enemyLeft) {
        this.enemyLeft = enemyLeft;
    }

    public Enemy getEnemyRight() {
        return enemyRight;
    }

    public void setEnemyRight(Enemy enemyRight) {
        this.enemyRight = enemyRight;
    }

    public BossEnemy getEnemyBoss() {
        return enemyBoss;
    }

    public void setEnemyBoss(BossEnemy enemyBoss) {
        this.enemyBoss = enemyBoss;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
