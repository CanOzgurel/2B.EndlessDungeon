import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements Runnable {
    private Thread thread;
    private final int FPS = 60;
    private boolean isRunning = false;
    private long targetTime = 1000 / FPS;

    public GamePanel() {
        // setFocusable(true);
        thread = new Thread(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ObjectHandler.getInstance().getEnemyLeft().clicked(e.getX(), e.getY());
                ObjectHandler.getInstance().getEnemyRight().clicked(e.getX(), e.getY());
                ObjectHandler.getInstance().getEnemyBoss().clicked(e.getX(), e.getY());
            }
        });
        start();
    }

    public void start() {
        isRunning = true;
        thread.start();
    }

    @Override
    public void run() {
        long start, elapsed, wait;

        while (isRunning) {
            start = System.nanoTime();

            update();
            repaint();

            elapsed = System.nanoTime() - start;
            wait = targetTime - elapsed / 1000000;

            if (wait < 0) {
                wait = 5;
            }

            try {
                Thread.sleep(wait);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        ObjectHandler.getInstance().update();
        GameManager.getInstance().manageEnemyAttacks();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(new ImageIcon("src/res/dungeon_wall.png").getImage(), 0, 0, GameFrame.WIDTH, GameFrame.HEIGHT, null);

        ObjectHandler.getInstance().render(g2d);
        renderHUD(g2d);

        g.dispose();
    }

    public void renderHUD(Graphics2D g) {
    	double health = ObjectHandler.getInstance().getPlayer().getHealth();
    	double maxHealth = ObjectHandler.getInstance().getPlayer().getMaxHealth();
    	double damage = ObjectHandler.getInstance().getPlayer().getDamage();
    	double armor = ObjectHandler.getInstance().getPlayer().getArmor();   
    	
    	Font newFont = new Font ("Bookman Old Style", Font.PLAIN , 15);
        g.setFont(newFont);
        g.setColor(Color.WHITE);
        g.drawString("Health:" + health , 10, 20);

        g.setColor(Color.GRAY);
        g.drawRect(110, 10, 100, 10);

        if (health <= 20) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(Color.GREEN);
        }

        g.fillRect(110, 11, (int)((health / maxHealth) * 99), 9 );

        g.setColor(Color.WHITE);
        g.drawString("Damage: " + damage, 220, 20);
        g.drawString("Armor: " + armor, 350, 20);
        
        Font newFont2 = new Font ("Batang", Font.BOLD , 35);
        g.setFont(newFont2);
        g.setColor(Color.ORANGE);
        g.drawString("STAGE: " + ObjectHandler.getInstance().getStage(), 480, 40);

       
    }
}
