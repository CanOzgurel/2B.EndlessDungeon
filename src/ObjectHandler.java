import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner; 

public class ObjectHandler {
    private static ObjectHandler instance = new ObjectHandler();
    private Enemy enemyLeft, enemyRight;
    private BossEnemy enemyBoss;
    private Player player;
    private Image imgEnemyLeft, imgEnemyRight, imgEnemyBoss;
    private double enemyHealth, enemyDamage, enemyArmor; 
    private double bossHealth, bossDamage, bossArmor;
    private double defPlayerHealth, playerDamage, playerArmor, playerHealth;
//    private PlayerType playerType;
    private int stage;
    private int level, experience, requiredExp, expGain, bossGain;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    

    protected  ObjectHandler() {
        imgEnemyLeft = new ImageIcon("src/res/enemy_basic_1.png").getImage();
        imgEnemyRight = new ImageIcon("src/res/enemy_basic_2.png").getImage();
        imgEnemyBoss = new ImageIcon("src/res/enemy_boss_1.png").getImage();
        
        enemyHealth = 100;
        enemyDamage = 10;
        enemyArmor = 2;
        bossHealth = 200;
        bossDamage = 15;
        bossArmor = 5;
        
        defPlayerHealth = 500;
        playerHealth = 500;
    	playerDamage = 50;
    	playerArmor = 8;
    	experience = 0;
    	requiredExp = 1000;
    	expGain = 100;
        
        	Skill Skill1 = new Skill("Skill1", 100 );
        	skills.add(0,Skill1);
        	Skill Skill2 = new Skill("Skill2", 200 );
        	skills.add(1,Skill2);
        	Skill Skill3 = new Skill("Skill3", 300 );
        	skills.add(2,Skill3);

        stage = 1;

        enemyLeft = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 1, imgEnemyLeft);
        enemyRight = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 2, imgEnemyRight);
        enemyBoss = new BossEnemy(bossHealth, bossHealth, bossDamage, bossArmor, 300, 400, imgEnemyBoss);
        player = new Player(playerHealth, defPlayerHealth, playerDamage, playerArmor, level, skills);
        
   
    }
    

    public void update() {
    	 if(enemyLeft.getHealth() <= 0 && enemyRight.getHealth() <= 0 && enemyBoss.getHealth() <= 0) {
    	
        enemyHealth += 10;
        enemyDamage += 2;
        enemyArmor += 1;
        bossHealth += 20;
        bossDamage += 5;
        bossArmor += 2;
        experience += expGain*2 + bossGain;
        expGain += 50;
        bossGain += 100;
        
        stage++;
        
        if(experience >= requiredExp) {
        	level++;
        	experience = 0;
        	requiredExp += 200;
        	defPlayerHealth += defPlayerHealth * (level/10);
        	playerDamage += 10;
        	playerArmor += 2;
        }
        
        playerHealth = defPlayerHealth;
       	
        
        enemyLeft = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 1, imgEnemyLeft);
        enemyRight = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 2, imgEnemyRight);
        enemyBoss = new BossEnemy(bossHealth, bossHealth, bossDamage, bossArmor, 300, 400, imgEnemyBoss);
        player = new Player(playerHealth, defPlayerHealth, playerDamage, playerArmor, level, skills);
    	 }
        
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
    
	public int getStage() {
		return stage;
	}

}

