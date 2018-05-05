import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ObjectHandler {
    private static ObjectHandler instance = new ObjectHandler();
    private Enemy enemyLeft, enemyRight;
    private BossEnemy enemyBoss;
    private Player player;
    private Image imgEnemyLeft, imgEnemyRight, imgEnemyBoss;
    private double enemyHealth, enemyDamage, enemyArmor; 
    private double bossHealth, bossDamage, bossArmor;
    private int bossType;
    private double defPlayerHealth, playerDamage, playerArmor, playerHealth;
//    private PlayerType playerType;
    private int stage;
    private int level, experience, requiredExp, expGain, bossGain, drop;
    private ArrayList<Skill> skills = new ArrayList<Skill>();
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private Item plateMail, dragonSword, scrollOfLight;
    

    protected  ObjectHandler() {
        imgEnemyLeft = new ImageIcon("src/res/enemy_basic_1.png").getImage();
        imgEnemyRight= new ImageIcon("src/res/enemy_basic_2.png").getImage();
        
        
        enemyHealth = 100;
        enemyDamage = 10;
        enemyArmor = 2;
        bossHealth = 200;
        bossDamage = 15;
        bossArmor = 5;
        
        Random rand = new Random();
        bossType = rand.nextInt(4) + 1;
        
        switch(bossType) {
        case 1:  imgEnemyBoss = new ImageIcon("src/res/enemy_fire_boss.png").getImage();
        		 break;
        case 2: imgEnemyBoss = new ImageIcon("src/res/enemy_ice_boss.png").getImage();
				 break;
		default: imgEnemyBoss = new ImageIcon("src/res/enemy_boss_1.png").getImage();
		 		 break;
        }
        
        
        defPlayerHealth = 500;
        playerHealth = 500;
    	playerDamage = 50;
    	playerArmor = 8;
    	experience = 0;
    	requiredExp = 1000;
    	expGain = 100;
        
        Skill SacredSword = new Skill("Skill1", playerDamage*3, "Melee");
        skills.add(SacredSword);
        Skill Fireball = new Skill("Skill2", playerDamage*2, "Fire" );
        skills.add(Fireball);
        Skill FrostNova = new Skill("Skill3", playerDamage*2, "Frost" );
        skills.add(FrostNova);
        
        plateMail = new Item(1, 0, 0, 10, "Plate Mail");
        dragonSword = new Item(2,0, 50, 0, "Dragon Sword");
        scrollOfLight = new Item(3, 200, 0, 0, "Scroll of Light");
        
        for(int i=0; i<3; i++) {
        	inventory.add(i, null);
        }
        	
        stage = 1;
                
        enemyLeft = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 1,0,  imgEnemyLeft);
        enemyRight = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 2, 0, imgEnemyRight);
        enemyBoss = new BossEnemy(bossHealth, bossHealth, bossDamage, bossArmor, 300, 400, bossType, imgEnemyBoss);
        player = new Player(playerHealth, defPlayerHealth, playerDamage, playerArmor, level, skills, inventory);
        
   
    }
    

    public void update() {
    	 if(turnUpdate()) {
    		     	
        enemyHealth += 10;
        enemyDamage += 2;
        enemyArmor += 1;
        bossHealth += 20;
        bossDamage += 5;
        bossArmor += 2;
        
        Random rand = new Random();
        bossType = rand.nextInt(4) + 1;
        
        switch(bossType) {
        case 1:  imgEnemyBoss = new ImageIcon("src/res/enemy_fire_boss.png").getImage();
        		 break;
        case 2:  imgEnemyBoss = new ImageIcon("src/res/enemy_ice_boss.png").getImage();
				 break;
		default: imgEnemyBoss = new ImageIcon("src/res/enemy_boss_1.png").getImage();
		 		 break;
        }
        
        experience += expGain*2 + bossGain;
        expGain += 50;
        bossGain += 100;
        
        
        Random randd = new Random();
        drop = randd.nextInt(100) + 1;
        
        if(drop >= 1 && drop <= 5 && !inventory.contains(plateMail)) {
        	inventory.set(0, plateMail);
        	playerArmor += plateMail.getExtraArmor();
        }
        if(drop >= 30 && drop <= 33 && !inventory.contains(dragonSword)) {
        	inventory.set(1,dragonSword);
        	playerDamage += dragonSword.getExtraDamage();
        }
        if(drop >= 70 && drop <= 72 && !inventory.contains(scrollOfLight)) {
        	inventory.set(2, scrollOfLight);
        	defPlayerHealth += scrollOfLight.getExtraHealth();
        }

        
        stage++;
        
        if(experience >= requiredExp) {
        	level++;
        	experience = 0;
        	requiredExp += 200;
        	defPlayerHealth += 100;
        	playerDamage += 10;
        	playerArmor += 2;
        }
        
        playerHealth = defPlayerHealth;
       	
        
        enemyLeft = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 1, 0, imgEnemyLeft);
        enemyRight = new Enemy(enemyHealth, enemyHealth, enemyDamage, enemyArmor, 150, 200, 2, 0, imgEnemyRight);
        enemyBoss = new BossEnemy(bossHealth, bossHealth, bossDamage, bossArmor, 300, 400, bossType, imgEnemyBoss);
        player = new Player(playerHealth, defPlayerHealth, playerDamage, playerArmor, level, skills, inventory);
    	 }
        
        enemyLeft.update();
        enemyRight.update();
        enemyBoss.update();
        player.update();
    }
    
    public boolean turnUpdate() {
    	if(enemyLeft.getHealth() <= 0 && enemyRight.getHealth() <= 0 && enemyBoss.getHealth() <= 0) 
    		return true;
    	else
    		return false;
    }

    public void render(Graphics2D g) {
        enemyLeft.render(g);
        enemyRight.render(g);
        enemyBoss.render(g);
        player.renderInventory(g);
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

